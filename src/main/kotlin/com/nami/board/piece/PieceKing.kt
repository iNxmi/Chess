package com.nami.board.piece

import com.nami.board.Board
import org.joml.Vector2i

class PieceKing(
    board: Board,
    team: Team,
    position: Vector2i
) : Piece(
    Type.KING,
    board,
    team,
    position
) {

    override fun getPossiblePositions(): List<Vector2i> {
        val positions = mutableListOf<Vector2i>()
        for (y in -1..1) for (x in -1..1) positions.add(Vector2i(position.x + x, position.y + y))

        val possiblePositions = positions
            .stream()
            .filter { position -> board.isMovePossible(position, team) }
            .toList()
        return possiblePositions
    }

}