package com.mgabbi.encryption.lib

import com.google.gson.Gson
import com.mgabbi.encryption.lib.data.Key
import java.util.Base64

fun createAPIKey(type: Algorithm): String {
    val pKey = (1..32).map { type.allowedChars.random() }.joinToString("")
    val json = Gson().toJson(Key(type, pKey))
    val encoder = Base64.getEncoder()
    return encoder.encodeToString(json.toByteArray())
}

fun decodeAPIKey(key: String): Key {
    val decoder = Base64.getDecoder()
    val raw = decoder.decode(key).toString(Charsets.UTF_8)
    val keyDecoded = Gson().fromJson(raw, Key::class.java)
    return keyDecoded
}