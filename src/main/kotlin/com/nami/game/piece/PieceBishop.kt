package com.nami.game.piece

import com.nami.game.board.Board
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

    private fun getPossiblePositions(direction: Vector2i): List<Vector2i> {
        val positions = mutableListOf<Vector2i>()
        for (i in 1 until max(board.size.x, board.size.y)) {
            val positionToCheck = Vector2i(position.x + i * direction.x, position.y + i * direction.y)
            if (!board.isMovePossible(positionToCheck, team))
                break

            positions.add(positionToCheck)

            if (board.getPiece(positionToCheck) != null)
                break
        }

        return positions
    }

    override fun getPossiblePositions(): List<Vector2i> {
        val positions: MutableList<Vector2i> = ArrayList()

        val directions = listOf(
            //DIAGONAL
            Vector2i(1, 1),
            Vector2i(1, -1),
            Vector2i(-1, 1),
            Vector2i(-1, -1)
        )

        for (direction in directions)
            positions.addAll(getPossiblePositions(direction))

        return positions
    }

}