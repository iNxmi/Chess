package com.nami.board.tile

import com.nami.Theme
import com.nami.board.Board
import com.nami.board.piece.Piece
import org.joml.Vector2i
import java.awt.Color
import java.awt.Font
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.SwingConstants

class Tile(
    val board: Board,
    val position: Vector2i,
) : JButton() {

    private var color =
        if (((position.x + (if (position.y % 2 == 0) 1 else 0)) % 2 == 1)) Theme.BOARD_TILE_WHITE_COLOR else Theme.BOARD_TILE_BLACK_COLOR

    private val foreground = JLabel()
    var piece: Piece? = null
        set(value) {
            field = value

            if (value == null) {
                setText("")
            } else {
                setText(value.getIcon())
                setForeground(if (value.team == Piece.Team.WHITE) Theme.BOARD_PIECE_WHITE_COLOR else Theme.BOARD_PIECE_BLACK_COLOR)
            }
        }

    init {
        foreground.text = String.format("%d | %d", position.x, position.y)
        foreground.foreground = Color(0, 0, 0, 150)
        foreground.font = Font("Arial", Font.PLAIN, 32)
        foreground.horizontalAlignment = SwingConstants.CENTER
        foreground.verticalAlignment = SwingConstants.CENTER
        add(foreground)

        setHorizontalAlignment(SwingConstants.CENTER)
        setVerticalAlignment(SwingConstants.CENTER)

        setBorderPainted(false)
        setFocusPainted(false)
        setBackground(color)
        setFont(Font("Serif", Font.PLAIN, Board.PIECE_SIZE))
    }

}