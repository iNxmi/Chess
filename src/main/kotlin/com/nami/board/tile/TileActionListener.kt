package com.nami.board.tile

import com.nami.Theme
import com.nami.board.Board
import com.nami.board.piece.Piece.Team
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TileActionListener(val board: Board) : ActionListener {

    private var selectedTile: Tile? = null
    private var turn = Team.WHITE

    override fun actionPerformed(e: ActionEvent) {
        val clickedTile = e.source as Tile
        val piece = clickedTile.piece

        if (selectedTile == null) {
            if (piece == null)
                return

            if (piece.team !== turn)
                return

            selectedTile = clickedTile

            clickedTile.background = Theme.BOARD_TILE_SELECTED_COLOR
            for (position in piece.getPossiblePositions()) {
//                board.getTile(position).setBackground(Theme.BOARD_TILE_SELECTED_COLOR);
                board.getTile(position).setText("●")
            }
        } else {
            if (selectedTile == clickedTile) {
                selectedTile = null
            } else {
                if (board.movePiece(selectedTile!!.position, clickedTile.position))
                    swapTurn()

//                board.getTiles()
//                    .forEach { (`_`: Point?, tile: error.NonExistentClass?) -> tile.setBackground(tile.getColor()) }
                selectedTile = null
            }
//            board.getTiles()
//                .forEach { (`_`: Point?, tile: error.NonExistentClass?) -> tile.setBackground(tile.getColor()) }
        }
    }

    fun swapTurn() {
        turn = if ((turn == Team.WHITE)) Team.BLACK else Team.WHITE
    }


}