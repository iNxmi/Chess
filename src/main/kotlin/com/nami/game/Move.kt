package com.nami.game

import org.joml.Vector2i

data class Move(
    val from: Vector2i,
    val to: Vector2i,
    val capture: Vector2i
)