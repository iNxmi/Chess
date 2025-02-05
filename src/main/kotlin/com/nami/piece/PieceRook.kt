package com.nami.piece

import com.nami.board.Board
import org.joml.Vector2i

class PieceRook(
    board: Board,
    team: Team,
    position: Vector2i
) : Piece(
    Type.ROOK,
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

        return positions
    }

}