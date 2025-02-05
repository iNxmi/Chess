package com.nami

import java.awt.Color
import java.io.FileInputStream
import java.nio.file.Path
import java.util.*

class Theme private constructor() {

    companion object {


        val DEFAULT_BOARD_TILE_WHITE_COLOR: Color = Color.WHITE
        val DEFAULT_BOARD_TILE_BLACK_COLOR: Color = Color.BLACK

        val DEFAULT_BOARD_TILE_HIGHLIGHT_COLOR: Color = Color.GRAY

        val DEFAULT_BOARD_PIECE_WHITE_COLOR: Color = Color.LIGHT_GRAY
        val DEFAULT_BOARD_PIECE_BLACK_COLOR: Color = Color.DARK_GRAY


        var BOARD_TILE_WHITE_COLOR: Color = DEFAULT_BOARD_TILE_WHITE_COLOR
        var BOARD_TILE_BLACK_COLOR: Color = DEFAULT_BOARD_TILE_BLACK_COLOR

        var BOARD_TILE_HIGHLIGHT_COLOR: Color = DEFAULT_BOARD_TILE_HIGHLIGHT_COLOR

        var BOARD_PIECE_WHITE_COLOR: Color = DEFAULT_BOARD_PIECE_WHITE_COLOR
        var BOARD_PIECE_BLACK_COLOR: Color = DEFAULT_BOARD_PIECE_BLACK_COLOR


        init {
            select("lichess")
        }

        fun select(name: String) {
            val properties = load(name)

            BOARD_TILE_WHITE_COLOR = Color(
                properties.getOrDefault("board.tile.white.color", DEFAULT_BOARD_TILE_WHITE_COLOR.rgb)
                    .toString().toUInt(16).toInt(),
                true
            )

            BOARD_TILE_BLACK_COLOR = Color(
                properties.getOrDefault("board.tile.black.color", DEFAULT_BOARD_TILE_BLACK_COLOR.rgb)
                    .toString().toUInt(16).toInt(),
                true
            )

            BOARD_TILE_HIGHLIGHT_COLOR = Color(
                properties.getOrDefault("board.tile.highlight.color", DEFAULT_BOARD_TILE_HIGHLIGHT_COLOR.rgb)
                    .toString().toUInt(16).toInt(),
                true
            )

            BOARD_PIECE_WHITE_COLOR = Color(
                properties.getOrDefault("board.piece.white.color", DEFAULT_BOARD_PIECE_WHITE_COLOR.rgb)
                    .toString().toUInt(16).toInt(),
                true
            )

            BOARD_PIECE_BLACK_COLOR = Color(
                properties.getOrDefault("board.piece.black.color", DEFAULT_BOARD_PIECE_BLACK_COLOR.rgb)
                    .toString().toUInt(16).toInt(),
                true
            )

        }

        private fun load(name: String): Properties {
            val properties = Properties()
            val path = Path.of("src", "main", "resources", "themes", String.format("%s.properties", name))

            val fileInputStream = FileInputStream(path.toFile())
            properties.load(fileInputStream)
            fileInputStream.close()

            return properties
        }

    }

}