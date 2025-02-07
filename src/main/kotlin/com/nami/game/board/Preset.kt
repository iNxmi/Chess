package com.nami.game.board;

import com.nami.serialization.SerializerVector2i
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.joml.Vector2i
import java.nio.file.Files
import java.nio.file.Paths

@Serializable
data class PieceJSON(val type: String, val team: String)

@Serializable
data class Preset(
    @Serializable(with = SerializerVector2i::class)
    val size: Vector2i,
    val pieces: Map<Int, Map<Int, PieceJSON>>
) {

    companion object {

        private val path = Paths.get("src", "main", "resources", "presets")

        fun load(name: String): Preset {
            val string = Files.readString(path.resolve("$name.json"))
            return Json.decodeFromString<Preset>(string)
        }

    }

}
