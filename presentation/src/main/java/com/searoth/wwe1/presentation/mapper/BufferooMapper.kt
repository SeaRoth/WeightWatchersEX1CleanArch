package com.searoth.wwe1.presentation.mapper

import com.searoth.wwe1.domain.model.Bufferoo
import com.searoth.wwe1.presentation.model.BufferooView
import javax.inject.Inject

/**
 * Map a [BufferooView] to and from a [Bufferoo] instance when data is moving between
 * this layer and the Domain layer
 */
open class BufferooMapper @Inject constructor(): Mapper<BufferooView, Bufferoo> {

    /**
     * Map a [Bufferoo] instance to a [BufferooView] instance
     */
    override fun mapToView(type: Bufferoo): BufferooView {
        return BufferooView(type.name, type.title, type.avatar)
    }


}