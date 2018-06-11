package com.searoth.wwe1.ui.test.factory

import com.searoth.wwe1.presentation.model.BufferooView
import com.searoth.wwe1.ui.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooView(): BufferooView {
            return BufferooView(randomUuid(), randomUuid(), randomUuid())
        }

    }

}