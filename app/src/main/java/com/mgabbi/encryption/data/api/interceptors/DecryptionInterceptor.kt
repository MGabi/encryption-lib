package com.mgabbi.encryption.data.api.interceptors

import android.util.Log
import com.mgabbi.encryption.lib.Encryption
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class DecryptionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d(tag, ">>>>>>>>>>>>>>>>  Decrypting body <<<<<<<<<<<<<<<<")
        val response = chain.proceed(chain.request())

        if (response.isSuccessful) {
            val newResponse = response.newBuilder()

//            val mediaType = (response.header("Content-Type")?.takeIf { it.isNotEmpty() }
//                ?: "application/json").toMediaType()

            val encryptedResponse = response.body?.bytes() ?: byteArrayOf()
            val decryptedResponse = Encryption.decode(encryptedResponse)

            Log.d(tag, "Encrypted response: $encryptedResponse")
            Log.d(tag, "Decrypted response: $decryptedResponse")

            newResponse.body(decryptedResponse.toResponseBody())

            return newResponse.build()
        }

        return response
    }
}
