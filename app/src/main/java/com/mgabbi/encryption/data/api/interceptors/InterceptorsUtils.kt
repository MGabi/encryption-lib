package com.mgabbi.encryption.data.api.interceptors

import okhttp3.RequestBody
import okio.Buffer

fun RequestBody.requestBodyToRawString(): String {
    val buffer = Buffer()
    writeTo(buffer)
    return buffer.readUtf8()
}

val tag = "OkHttpClient"
