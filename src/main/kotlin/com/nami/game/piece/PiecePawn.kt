package com.nami.game.piece

import com.nami.game.board.Board
import org.joml.Vector2i

class PiecePawn(
    board: Board,
    team: Team,
    position: Vector2i
) : Piece(
    Type.PAWN,
    board,
    team,
    position
) {

    override fun getPossiblePositions(): List<Vector2i> {
        val positions: MutableList<Vector2i> = ArrayList()

        val yDirection = if (team == Team.WHITE) -1 else 1

        for (i in 1..2) {
            val positionToCheck = Vector2i(position.x, position.y + i * yDirection)
            if (!board.isMovePossible(positionToCheck, team))
                break

            if (board.getPiece(positionToCheck) != null)
                break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null)
                break

            if (moveCount > 0)
                break
        }

        val enemyPositions: MutableList<Vector2i> = ArrayList()
        enemyPositions.add(Vector2i(position.x + 1, position.y + yDirection))
        enemyPositions.add(Vector2i(position.x - 1, position.y + yDirection))

        for (enemyPosition in enemyPositions) {
            if (!board.isMovePossible(enemyPosition, team)) continue

            if (board.getPiece(enemyPosition) == null) continue

            positions.add(enemyPosition)
        }

        return positions
    }

}