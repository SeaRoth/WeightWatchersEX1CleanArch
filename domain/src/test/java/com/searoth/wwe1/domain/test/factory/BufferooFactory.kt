package com.searoth.wwe1.domain.test.factory

import com.searoth.wwe1.domain.model.Bufferoo
import com.searoth.wwe1.domain.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooList(count: Int): List<Bufferoo> {
            val bufferoos = mutableListOf<Bufferoo>()
            repeat(count) {
                bufferoos.add(makeBufferoo())
            }
            return bufferoos
        }

        fun makeBufferoo(): Bufferoo {
            return Bufferoo(randomUuid(), randomUuid(), randomUuid())
        }

    }

}