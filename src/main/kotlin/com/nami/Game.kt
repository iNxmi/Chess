package com.nami

import com.nami.board.Board
import com.nami.piece.Piece
import com.nami.status.GameInformation
import com.nami.status.PlayerInformation
import org.joml.Vector2i
import javax.swing.Box
import javax.swing.JFrame

class Game : JFrame() {

    private val board = Board(Vector2i(8, 8))
    private val informationBlack: PlayerInformation = PlayerInformation(Piece.Team.BLACK)
    private val informationWhite: PlayerInformation = PlayerInformation(Piece.Team.WHITE)
    private val informationGame: GameInformation = GameInformation()

    init {
        title = "Chess"
        defaultCloseOperation = EXIT_ON_CLOSE

        val vbox = Box.createVerticalBox()
        vbox.add(informationBlack)
        vbox.add(board)
        vbox.add(informationWhite)

        val hbox = Box.createHorizontalBox()
        hbox.add(vbox)
        hbox.add(informationGame)

        add(hbox)
        pack()
        setLocationRelativeTo(null)
        isResizable = false

        createPieces()

        isVisible = true
    }

    private fun createPieces() {
        //White Pawns
        for (x in 0..<board.size.x)
            board.createPiece(Vector2i(x, 6), Piece.Type.PAWN, Piece.Team.WHITE)

        //Black Pawns
        for (x in 0..<board.size.y)
            board.createPiece(Vector2i(x, 1), Piece.Type.PAWN, Piece.Team.BLACK)

        //ROOKS
        board.createPiece(Vector2i(0, 0), Piece.Type.ROOK, Piece.Team.BLACK)
        board.createPiece(Vector2i(7, 0), Piece.Type.ROOK, Piece.Team.BLACK)
        board.createPiece(Vector2i(0, 7), Piece.Type.ROOK, Piece.Team.WHITE)
        board.createPiece(Vector2i(7, 7), Piece.Type.ROOK, Piece.Team.WHITE)

        //Knights
        board.createPiece(Vector2i(1, 0), Piece.Type.KNIGHT, Piece.Team.BLACK)
        board.createPiece(Vector2i(6, 0), Piece.Type.KNIGHT, Piece.Team.BLACK)
        board.createPiece(Vector2i(1, 7), Piece.Type.KNIGHT, Piece.Team.WHITE)
        board.createPiece(Vector2i(6, 7), Piece.Type.KNIGHT, Piece.Team.WHITE)

        //Bishops
        board.createPiece(Vector2i(2, 0), Piece.Type.BISHOP, Piece.Team.BLACK)
        board.createPiece(Vector2i(5, 0), Piece.Type.BISHOP, Piece.Team.BLACK)
        board.createPiece(Vector2i(2, 7), Piece.Type.BISHOP, Piece.Team.WHITE)
        board.createPiece(Vector2i(5, 7), Piece.Type.BISHOP, Piece.Team.WHITE)

        //Queens
        board.createPiece(Vector2i(3, 0), Piece.Type.QUEEN, Piece.Team.BLACK)
        board.createPiece(Vector2i(3, 7), Piece.Type.QUEEN, Piece.Team.WHITE)

        //Kings
        board.createPiece(Vector2i(4, 0), Piece.Type.KING, Piece.Team.BLACK)
        board.createPiece(Vector2i(4, 7), Piece.Type.KING, Piece.Team.WHITE)
    }

}