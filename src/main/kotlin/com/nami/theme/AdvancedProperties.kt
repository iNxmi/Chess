package com.nami.theme

import java.awt.Color
import java.io.FileInputStream
import java.nio.file.Path
import java.util.*

class AdvancedProperties : Properties() {

    fun load(path: Path): AdvancedProperties {
        val fileInputStream = FileInputStream(path.toFile())
        load(fileInputStream)
        fileInputStream.close()

        return this
    }

    fun getString(key: Any): String {
        return get(key).toString()
    }

    fun getInt(key: Any, radix: Int = 10): Int {
        return getString(key).toInt(radix)
    }

    fun getUInt(key: Any, radix: Int = 10): UInt {
        return getString(key).toUInt(radix)
    }

    // Loads a color as RGBA
    fun getHexColor(key: Any): Color {
        val color = getUInt(key, 16).toInt()

        val red = color shr 16 and 0xFF
        val green = color shr 8 and 0xFF
        val blue = color and 0xFF
        val alpha = color shr 24 and 0xFF

        return Color(red, green, blue, alpha)
    }

}