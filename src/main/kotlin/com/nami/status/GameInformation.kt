package com.nami.status

import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JLabel

class GameInformation : Box(BoxLayout.Y_AXIS) {

    private val history = MoveHistory()

    init {
        add(JLabel("Time"))
        add(history)
    }

}