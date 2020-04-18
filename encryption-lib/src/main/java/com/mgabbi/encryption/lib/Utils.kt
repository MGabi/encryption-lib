package com.mgabbi.encryption.lib

import com.google.gson.Gson
import com.mgabbi.encryption.lib.data.Key
import java.util.Base64
import javax.crypto.KeyGenerator

fun Encryption.createAPIKey(type: Algorithm): String {
    val encoder = Base64.getEncoder()
    val gson = Gson()

    val generator = KeyGenerator.getInstance(type.toString()).apply { init(type.keySize) }
    val pKey = generator.generateKey()

    val json = gson.toJson(
        Key(
            type,
            encoder.encodeToString(pKey.encoded)
        )
    )
    return encoder.encodeToString(json.toByteArray())
}

fun Encryption.decodeAPIKey(key: String): Key {
    val decoder = Base64.getDecoder()
    val rawString = decoder.decode(key).toString(Charsets.UTF_8)
    return Gson().fromJson(rawString, Key::class.java)
}
