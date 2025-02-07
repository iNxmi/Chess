package com.nami.game.board

import com.nami.theme.Theme
import com.nami.game.piece.Piece
import org.joml.Vector2i
import java.awt.Dimension
import java.awt.Font
import java.awt.Rectangle
import javax.swing.JLabel
import javax.swing.JLayeredPane
import javax.swing.JPanel
import javax.swing.SwingConstants

class Tile(
    val board: Board,
    val position: Vector2i,
) : JLayeredPane() {

    private val color = if ((position.x + (position.y % 2)) % 2 == 0) {
        Theme.BOARD_TILE_WHITE_COLOR
    } else {
        Theme.BOARD_TILE_BLACK_COLOR
    }

    private val backgroundPanel = JPanel()
    private val pieceLabel = JLabel()
    private val highlightLabel = JLabel()

    var piece: Piece? = null
        set(value) {
            field = value

            if (value == null) {
                pieceLabel.text = ""
            } else {
                pieceLabel.text = value.getIcon()
                pieceLabel.foreground =
                    if (value.team == Piece.Team.WHITE) Theme.BOARD_PIECE_WHITE_COLOR else Theme.BOARD_PIECE_BLACK_COLOR
            }
        }

    init {
        size = Dimension(Board.TILE_SIZE, Board.TILE_SIZE)

        pieceLabel.font = Font("Serif", Font.PLAIN, Board.PIECE_SIZE)
        pieceLabel.setOpaque(false)
        pieceLabel.verticalAlignment = SwingConstants.CENTER
        pieceLabel.horizontalAlignment = SwingConstants.CENTER
        pieceLabel.bounds = Rectangle(0, 0, Board.TILE_SIZE, Board.TILE_SIZE)
        add(pieceLabel)

        highlightLabel.font = Font("Serif", Font.PLAIN, Board.HIGHLIGHT_SIZE)
        highlightLabel.foreground = Theme.BOARD_TILE_HIGHLIGHT_COLOR
        highlightLabel.setOpaque(false)
        highlightLabel.verticalAlignment = SwingConstants.CENTER
        highlightLabel.horizontalAlignment = SwingConstants.CENTER
        highlightLabel.bounds = Rectangle(0, 0, Board.TILE_SIZE, Board.TILE_SIZE)
        add(highlightLabel)

        backgroundPanel.background = color
        backgroundPanel.setOpaque(true)
        backgroundPanel.bounds = Rectangle(0, 0, Board.TILE_SIZE, Board.TILE_SIZE)
        add(backgroundPanel)
    }

    fun highlight(team: Piece.Team) {
        if (piece == null) {
            highlightLabel.text = Highlight.MOVE.icon
        } else if (piece != null) {
            if (piece!!.team == team) {
                highlightLabel.text = Highlight.SELECTED.icon
            } else {
                highlightLabel.text = Highlight.CAPTURE.icon
            }
        }
    }

    fun removeHighlight() {
        highlightLabel.text = ""
    }

    enum class Highlight(val icon: String) {
        SELECTED("●"),
        MOVE("○"),
        CAPTURE("◌")
    }

}