package com.nami.piece

import com.nami.board.Board
import org.joml.Vector2i
import kotlin.math.max

class PieceBishop(
    board: Board,
    team: Team,
    position: Vector2i
) : Piece(
    Type.BISHOP,
    board,
    team,
    position
) {

    override fun getPossiblePositions(): List<Vector2i> {
        val positions = mutableListOf<Vector2i>()
        val boardSize = board.size

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