package com.mgabbi.encryption.lib

import com.google.gson.Gson
import com.mgabbi.encryption.lib.data.Key
import java.util.Base64

fun createAPIKey(type: Algorithm, pkey: String): String {
    val key = Key(type, pkey)
    val json = Gson().toJson(key)
    val encoder = Base64.getEncoder()
    return encoder.encodeToString(json.toByteArray())
}