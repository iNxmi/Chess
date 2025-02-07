package com.nami.scene

import com.nami.game.board.Board
import com.nami.game.board.Preset
import com.nami.game.piece.Piece
import com.nami.game.status.GameInformation
import com.nami.game.status.PlayerInformation
import org.joml.Vector2i
import java.awt.Color
import java.awt.Component
import javax.swing.Box
import javax.swing.JPanel

class SceneGame : JPanel(), Scene {

    private val preset = Preset.load("default")

    private val board = Board(preset.size)
    private val informationBlack: PlayerInformation = PlayerInformation(Piece.Team.BLACK)
    private val informationWhite: PlayerInformation = PlayerInformation(Piece.Team.WHITE)
    private val informationGame: GameInformation = GameInformation()

    init {
        val vbox = Box.createVerticalBox()
        vbox.add(informationBlack)
        vbox.add(board)
        vbox.add(informationWhite)

        val hBox = Box.createHorizontalBox()
        hBox.add(vbox)
        hBox.add(informationGame)

        add(hBox)

        createPieces()

        background = Color.red
    }

    private fun createPieces() {
        for ((y, map) in preset.pieces)
            for ((x, json) in map) {
                val position = Vector2i(x, y)

                val type = when (json.type) {
                    "pawn" -> Piece.Type.PAWN
                    "bishop" -> Piece.Type.BISHOP
                    "rook" -> Piece.Type.ROOK
                    "king" -> Piece.Type.KING
                    "queen" -> Piece.Type.QUEEN
                    "knight" -> Piece.Type.KNIGHT
                    else -> throw IllegalStateException()
                }

                val team = when (json.team) {
                    "white" -> Piece.Team.WHITE
                    "black" -> Piece.Team.BLACK
                    else -> throw IllegalStateException()
                }

                board.createPiece(position, type, team)
            }
    }

    override fun component(): Component = this

}