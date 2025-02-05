package com.nami.board

import java.awt.event.MouseEvent
import java.awt.event.MouseListener

class TileHandler(val board: Board) : MouseListener {

    override fun mouseClicked(e: MouseEvent) {}

    override fun mousePressed(e: MouseEvent) {
        val tile = e.source as Tile
        board.tilePressed(tile.position, e.button)
    }

    override fun mouseReleased(e: MouseEvent) {}

    override fun mouseEntered(e: MouseEvent) {}

    override fun mouseExited(e: MouseEvent) {}

}