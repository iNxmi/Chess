package com.nami.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.*
import org.joml.Vector2i

object SerializerVector2i : KSerializer<Vector2i> {

    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("com.nami.serialization.Vector2i") {
            element<Int>("x")
            element<Int>("y")
        }

    override fun deserialize(decoder: Decoder): Vector2i =
        decoder.decodeStructure(descriptor) {
            var x = 0
            var y = 0
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> x = decodeIntElement(descriptor, 0)
                    1 -> y = decodeIntElement(descriptor, 1)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }

            Vector2i(x, y)
        }

    override fun serialize(encoder: Encoder, value: Vector2i) =
        encoder.encodeStructure(descriptor) {
            encodeIntElement(descriptor, 0, value.x)
            encodeIntElement(descriptor, 1, value.y)
        }

}