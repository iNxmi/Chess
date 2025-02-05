package com.nami.piece

import com.nami.board.Board
import org.joml.Vector2i

abstract class Piece(
    private val type: Type,
    val board: Board,
    val team: Team,
    val position: Vector2i
) {

    var moveCount = 0

    fun getIcon(): String {
        return type.icon
    }

    fun move(destination: Vector2i) {
        position.set(destination)
        moveCount++
    }

    abstract fun getPossiblePositions(): List<Vector2i>

    enum class Team {
        WHITE,
        BLACK
    }

    enum class Type(val icon: String) {
        PAWN("♟"),
        KNIGHT("♞"),
        ROOK("♜"),
        BISHOP("♝"),
        KING("♚"),
        QUEEN("♛")
    }

}