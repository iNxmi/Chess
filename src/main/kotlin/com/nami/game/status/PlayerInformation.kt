package com.nami.game.status

import com.nami.theme.Theme
import com.nami.game.piece.Piece.Team
import java.awt.Color
import java.awt.Font
import java.awt.GridLayout
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingConstants

class PlayerInformation(
    team: Team
) : JPanel() {

    private val timeLabel = JLabel()
    private val teamLabel = JLabel()
    private val piecesLabel = JLabel()

    init {
        layout = GridLayout(1, 3)
        background = if (team == Team.WHITE) Theme.BOARD_TILE_WHITE_COLOR else Theme.BOARD_TILE_BLACK_COLOR
        border = BorderFactory.createLineBorder(Color.BLACK)

        timeLabel.text = "Time"
        timeLabel.font = Font("Arial", Font.PLAIN, 32)
        timeLabel.horizontalAlignment = SwingConstants.CENTER
        add(timeLabel)

        teamLabel.text = team.toString()
        teamLabel.font = Font("Arial", Font.PLAIN, 32)
        teamLabel.horizontalAlignment = SwingConstants.CENTER
        add(teamLabel)

        piecesLabel.text = "Pieces"
        piecesLabel.font = Font("Arial", Font.PLAIN, 32)
        piecesLabel.horizontalAlignment = SwingConstants.CENTER
        add(piecesLabel)
    }

}