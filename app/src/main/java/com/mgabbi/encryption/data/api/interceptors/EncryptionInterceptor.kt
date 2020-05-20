package com.mgabbi.encryption.data.api.interceptors

import android.util.Log
import com.mgabbi.encryption.lib.crypto.Encryption
import okhttp3.Interceptor
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

class EncryptionInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d(tag, ">>>>>>>>>>>>>>>>  Encrypting body <<<<<<<<<<<<<<<<")
        val request = chain.request()
        val unencryptedBody = request.body

        // val mediaType = "text/plain; charset=utf-8".toMediaType()

        val rawBodyString = unencryptedBody?.requestBodyToRawString() ?: ""
        val encryptedBody = Encryption.encode(rawBodyString)

        Log.d(tag, ">>>Encrypting>>> Raw body: $rawBodyString")
        Log.d(tag, ">>>Encrypting>>> Encrypted body: $encryptedBody")

        val newBody = encryptedBody.toRequestBody()

        val newRequest = request.newBuilder()
            .header("Content-Type", newBody.contentType().toString())
            .header("Content-Length", newBody.contentLength().toString())
            .method(request.method, newBody).build()
        return chain.proceed(newRequest)
    }
}
