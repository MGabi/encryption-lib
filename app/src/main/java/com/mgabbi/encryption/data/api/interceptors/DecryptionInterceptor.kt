package com.mgabbi.encryption.data.api.interceptors

import android.util.Log
import com.mgabbi.encryption.lib.crypto.Encryption
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class DecryptionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d(tag, ">>>>>>>>>>>>>>>>  Decrypting body <<<<<<<<<<<<<<<<")
        val response = chain.proceed(chain.request())

        if (response.isSuccessful) {
            val newResponse = response.newBuilder()

            val mediaType = "application/json; charset=UTF-8".toMediaType()

            val encryptedResponse = response.body?.bytes() ?: byteArrayOf()
            val decryptedResponse = Encryption.decrypt(encryptedResponse)

            Log.d(tag, ">>>Decrypting>>> Encrypted response: $encryptedResponse")
            Log.d(tag, ">>>Decrypting>>> Decrypted response: $decryptedResponse")

            val newBody = decryptedResponse.toResponseBody(mediaType)
            newResponse.body(newBody)

            return newResponse.build()
        }

        return response
    }
}
