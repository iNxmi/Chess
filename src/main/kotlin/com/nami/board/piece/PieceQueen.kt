package com.nami.board.piece

import com.nami.board.Board
import org.joml.Vector2i
import kotlin.math.max

class PieceQueen(
    board: Board,
    team: Team,
    position: Vector2i
) : Piece(
    Type.QUEEN,
    board,
    team,
    position
) {

    override fun getPossiblePositions(): List<Vector2i> {
        val positions: MutableList<Vector2i> = ArrayList()
        val boardSize = board.size

        //UP
        for (i in 1 until boardSize.y) {
            val positionToCheck = Vector2i(position.x, position.y - i)
            if (!board.isMovePossible(positionToCheck, team)) break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null) break
        }
        //DOWN
        for (i in 1 until boardSize.y) {
            val positionToCheck = Vector2i(position.x, position.y + i)
            if (!board.isMovePossible(positionToCheck, team)) break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null) break
        }
        //LEFT
        for (i in 1 until boardSize.x) {
            val positionToCheck = Vector2i(position.x - i, position.y)
            if (!board.isMovePossible(positionToCheck, team)) break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null) break
        }
        //RIGHT
        for (i in 1 until boardSize.x) {
            val positionToCheck = Vector2i(position.x + i, position.y)
            if (!board.isMovePossible(positionToCheck, team)) break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null) break
        }
        //TOP RIGHT
        for (i in 1 until max(boardSize.x.toDouble(), boardSize.y.toDouble()).toInt()) {
            val positionToCheck = Vector2i(position.x + i, position.y - i)
            if (!board.isMovePossible(positionToCheck, team)) break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null) break
        }
        //TOP LEFT
        for (i in 1 until max(boardSize.x.toDouble(), boardSize.y.toDouble()).toInt()) {
            val positionToCheck = Vector2i(position.x - i, position.y - i)
            if (!board.isMovePossible(positionToCheck, team)) break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null) break
        }
        //BOTTOM RIGHT
        for (i in 1 until max(boardSize.x.toDouble(), boardSize.y.toDouble()).toInt()) {
            val positionToCheck = Vector2i(position.x + i, position.y + i)
            if (!board.isMovePossible(positionToCheck, team)) break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null) break
        }
        //BOTTOM LEFT
        for (i in 1 until max(boardSize.x.toDouble(), boardSize.y.toDouble()).toInt()) {
            val positionToCheck = Vector2i(position.x - i, position.y + i)
            if (!board.isMovePossible(positionToCheck, team)) break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null) break
        }

        return positions
    }

}