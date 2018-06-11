package com.searoth.wwe1.remote

import io.reactivex.Single
import com.searoth.wwe1.remote.model.BufferooModel
import retrofit2.http.GET

/**
 * Defines the abstract methods used for interacting with the Bufferoo API
 */
interface BufferooService {

    @GET("team.json")
    fun getBufferoos(): Single<BufferooResponse>

    class BufferooResponse {
        lateinit var team: List<BufferooModel>
    }

}
