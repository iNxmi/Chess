package com.nami.theme

import java.awt.Color
import java.nio.file.Paths

class Theme private constructor() {

    companion object {

        private val root = Paths.get("src", "main", "resources", "themes")

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
            select("aria")
        }

        fun select(name: String) {
            val path = root.resolve("$name.properties")
            val properties = AdvancedProperties().load(path)

            BOARD_TILE_WHITE_COLOR =
                withDefault(properties.getHexColor("board.tile.white.color"), DEFAULT_BOARD_TILE_WHITE_COLOR)

            BOARD_TILE_BLACK_COLOR =
                withDefault(properties.getHexColor("board.tile.black.color"), DEFAULT_BOARD_TILE_BLACK_COLOR)

            BOARD_TILE_HIGHLIGHT_COLOR =
                withDefault(properties.getHexColor("board.tile.highlight.color"), DEFAULT_BOARD_TILE_HIGHLIGHT_COLOR)

            BOARD_PIECE_WHITE_COLOR =
                withDefault(properties.getHexColor("board.piece.white.color"), DEFAULT_BOARD_PIECE_WHITE_COLOR)

            BOARD_PIECE_BLACK_COLOR =
                withDefault(properties.getHexColor("board.piece.black.color"), DEFAULT_BOARD_PIECE_BLACK_COLOR)
        }

        private fun <T : Any> withDefault(value: T?, default: T): T {
            return value ?: default
        }

    }

}