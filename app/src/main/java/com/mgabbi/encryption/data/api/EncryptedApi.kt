package com.mgabbi.encryption.data.api

import com.mgabbi.encryption.data.models.SimpleResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface EncryptedApi {
    @POST("testEncryption")
    suspend fun sendMessage(@Body message: String): SimpleResponse
}
