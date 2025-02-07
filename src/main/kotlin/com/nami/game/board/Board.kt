package com.nami.game.board

import com.nami.game.piece.*
import com.nami.game.piece.Piece.Team
import org.joml.Vector2i
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.event.MouseEvent
import javax.swing.JOptionPane
import javax.swing.JPanel

class Board(val size: Vector2i) : JPanel() {

    companion object {
        val TILE_SIZE: Int = 64
        val PIECE_SIZE: Int = 56
        val HIGHLIGHT_SIZE: Int = 64
    }

    private val tiles = mutableMapOf<Vector2i, Tile>()

    init {
        layout = GridLayout(size.x, size.y)
        preferredSize = Dimension(size.x * TILE_SIZE, size.y * TILE_SIZE)

        createTiles()
    }

    private fun createTiles() {
        val listener = TileHandler(this)

        for (y in 0 until size.y) for (x in 0 until size.x) {
            val tile = Tile(this, Vector2i(x, y))
            tile.addMouseListener(listener)

            tiles[Vector2i(x, y)] = tile
            add(tile)
        }
    }

    fun createPiece(position: Vector2i, type: Piece.Type, team: Team) {
        val piece: Piece = when (type) {
            Piece.Type.PAWN -> PiecePawn(this, team, position)
            Piece.Type.KNIGHT -> PieceKnight(this, team, position)
            Piece.Type.BISHOP -> PieceBishop(this, team, position)
            Piece.Type.ROOK -> PieceRook(this, team, position)
            Piece.Type.KING -> PieceKing(this, team, position)
            Piece.Type.QUEEN -> PieceQueen(this, team, position)
        }

        setPiece(piece.position, piece)
    }

    fun getTile(position: Vector2i): Tile {
        return tiles[position]!!
    }

    fun getPiece(position: Vector2i): Piece? {
        val tile: Tile = getTile(position)
        return tile.piece
    }

    fun movePiece(position: Vector2i, destination: Vector2i): Boolean {
        val piece = getPiece(position)!!

        if (!piece.getPossiblePositions().contains(destination))
            return false

        val positionTile = getTile(position)
        val destinationTile = getTile(destination)

        positionTile.piece = null
        destinationTile.piece = piece

        piece.move(destination)

//        moves.add(Move(position, destination))

        if (piece.type != Piece.Type.PAWN)
            return true

        if (destination.y <= 0 || destination.y >= size.y - 1) {
            val options = arrayOf(
                Piece.Type.BISHOP,
                Piece.Type.KNIGHT,
                Piece.Type.QUEEN,
                Piece.Type.ROOK
            )

            val index = JOptionPane.showOptionDialog(
                this,
                "Select Piece.Type",
                "Convert Pawn",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                Piece.Type.QUEEN
            )

            createPiece(destination, options[index], piece.team)
        }

        return true
    }

    fun setPiece(position: Vector2i, piece: Piece?) {
        val tile = getTile(position)
        tile.piece = piece
    }

    fun isMovePossible(position: Vector2i, team: Team): Boolean {
        if (position.x < 0 || position.x >= size.x) return false

        if (position.y < 0 || position.y >= size.y) return false

        val piece = getPiece(position) ?: return true

        return piece.team != team
    }

    var selected: Vector2i? = null
    fun tilePressed(position: Vector2i, button: Int) {

        if (button == MouseEvent.BUTTON1) {

            removeHighlighting()

            if (selected != null && selected != position) {
                val selectedPiece = getPiece(selected!!) ?: throw IllegalStateException()
                if (selectedPiece.getPossiblePositions().contains(position)) {
                    movePiece(selected!!, position)
                    selected = null
                    return
                }
            }

            selected = null

            val piece = getPiece(position) ?: return
            selected = position
            highlightPossibleMoves(piece)
        } else if (button == MouseEvent.BUTTON3) {
            selected = null
            removeHighlighting()
        }
    }

    private fun highlightPossibleMoves(piece: Piece) {
        getTile(piece.position).highlight(piece.team)
        piece.getPossiblePositions().forEach { position ->
            val tile = getTile(position)
            tile.highlight(piece.team)
        }
    }

    private fun removeHighlighting() {
        tiles.forEach { (_, tile) -> tile.removeHighlight() }
    }

}