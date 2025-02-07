package com.nami.game.input

import org.joml.Vector2i
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JPanel

class Input(
    val size: Vector2i
) : JPanel() {

    init {
        addMouseListener(Handler())
    }

    class Handler : MouseListener {
        override fun mouseClicked(e: MouseEvent?) {}

        override fun mousePressed(e: MouseEvent?) {

        }

        override fun mouseReleased(e: MouseEvent?) {}

        override fun mouseEntered(e: MouseEvent?) {}

        override fun mouseExited(e: MouseEvent?) {}
    }

}