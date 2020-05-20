package com.mgabbi.encryption.lib.key

import com.google.gson.Gson
import com.mgabbi.encryption.lib.Algorithm
import com.mgabbi.encryption.lib.data.Key
import com.mgabbi.encryption.lib.mainAlgorithm
import com.mgabbi.encryption.lib.randomIV
import java.util.Base64
import javax.crypto.KeyGenerator

interface IKeyUtils {
    fun createAPIKey(type: Algorithm): String
    fun decodeAPIKey(key: String): Key
}

internal class KeyUtilsImpl : IKeyUtils {
    override fun createAPIKey(type: Algorithm): String {
        val encoder = Base64.getEncoder()
        val gson = Gson()

        val generator = KeyGenerator.getInstance(type.mainAlgorithm()).apply { init(type.keySize) }
        val pKey = generator.generateKey()

        val json = gson.toJson(
            Key(
                type,
                encoder.encodeToString(pKey.encoded),
                type.randomIV()
            )
        )
        return encoder.encodeToString(json.toByteArray())
    }

    override fun decodeAPIKey(key: String): Key {
        val decoder = Base64.getDecoder()
        val rawString = decoder.decode(key).toString(Charsets.UTF_8)
        return Gson().fromJson(rawString, Key::class.java)
    }
}
