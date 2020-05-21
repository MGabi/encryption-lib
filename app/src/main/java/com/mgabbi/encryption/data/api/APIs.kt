package com.mgabbi.encryption.data.api

import com.mgabbi.encryption.data.models.SimpleRequest
import com.mgabbi.encryption.data.models.SimpleResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface EncryptedApi {
    @POST("testEncryption")
    suspend fun sendMessage(@Body message: SimpleRequest): SimpleResponse
}

interface SimpleApi {
    @POST("testRawResponse")
    suspend fun sendMessageRaw(@Body message: SimpleRequest): SimpleResponse
}
