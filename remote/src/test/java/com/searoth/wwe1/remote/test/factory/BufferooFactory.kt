package com.searoth.wwe1.remote.test.factory

import com.searoth.wwe1.remote.test.factory.DataFactory.Factory.randomUuid
import com.searoth.wwe1.remote.BufferooService
import com.searoth.wwe1.remote.model.BufferooModel

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooResponse(): BufferooService.BufferooResponse {
            val bufferooResponse = BufferooService.BufferooResponse()
            bufferooResponse.team = makeBufferooModelList(5)
            return bufferooResponse
        }

        fun makeBufferooModelList(count: Int): List<BufferooModel> {
            val bufferooEntities = mutableListOf<BufferooModel>()
            repeat(count) {
                bufferooEntities.add(makeBufferooModel())
            }
            return bufferooEntities
        }

        fun makeBufferooModel(): BufferooModel {
            return BufferooModel(randomUuid(), randomUuid(), randomUuid())
        }

    }

}