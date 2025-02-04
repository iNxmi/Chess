package com.nami.board

import com.nami.board.piece.*
import com.nami.board.piece.Piece.Team
import com.nami.board.tile.Tile
import com.nami.board.tile.TileActionListener
import com.nami.move.Move
import org.joml.Vector2i
import java.awt.Dimension
import java.awt.GridLayout
import java.util.*
import javax.swing.JPanel

class Board(val size: Vector2i) : JPanel() {

    companion object {
        val TILE_SIZE: Int = 128
        val PIECE_SIZE: Int = 90
    }

    private val tiles = mutableMapOf<Vector2i, Tile>()
    private val moves = LinkedList<Move>()

    init {
        layout = GridLayout(size.x, size.y)
        preferredSize = Dimension(size.x * TILE_SIZE, size.y * TILE_SIZE)

        createTiles()
    }

    private fun createTiles() {
        val listener = TileActionListener(this)

        for (y in 0 until size.y) for (x in 0 until size.x) {
            val tile = Tile(this, Vector2i(x, y))
            tile.addActionListener(listener)

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

        setPiece(position, piece)
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

        if (!piece.getPossiblePositions().contains(destination)) return false

        val positionTile = getTile(position)
        val destinationTile = getTile(destination)

        positionTile.piece = null
        destinationTile.piece = piece

        piece.move(destination)

        moves.add(Move(position, destination))

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

}