package com.nami.game.piece

import com.nami.game.board.Board
import org.joml.Vector2i

class PieceKnight(
    board: Board,
    team: Team,
    position: Vector2i
) : Piece(
    Type.KNIGHT,
    board,
    team,
    position
) {

    override fun getPossiblePositions(): List<Vector2i> {
        val positions = mutableListOf<Vector2i>()

        positions.add(Vector2i(position.x + 1, position.y + 2))
        positions.add(Vector2i(position.x - 1, position.y + 2))

        positions.add(Vector2i(position.x + 1, position.y - 2))
        positions.add(Vector2i(position.x - 1, position.y - 2))

        positions.add(Vector2i(position.x + 2, position.y + 1))
        positions.add(Vector2i(position.x + 2, position.y - 1))

        positions.add(Vector2i(position.x - 2, position.y + 1))
        positions.add(Vector2i(position.x - 2, position.y - 1))

        val possiblePositions = positions
            .stream()
            .filter { position -> board.isMovePossible(position, team) }
            .toList()
        return possiblePositions
    }

}