package com.mgabbi.encryption.lib

import com.google.gson.Gson
import com.mgabbi.encryption.lib.data.Key
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.IvParameterSpec

object Encryption {

    private lateinit var key: Key

    fun init(keyStr: String) {
        this.key = decodeAPIKey(keyStr)
    }

    fun encode(message: String): ByteArray {
        val cipher = Cipher.getInstance(key.type.keyString()).apply {
            initForKey(key, Cipher.ENCRYPT_MODE)
        }
        return cipher.doFinal(message.toByteArray())
    }

    fun decode(message: ByteArray): String {
        val cipher = Cipher.getInstance(key.type.keyString()).apply {
            initForKey(key, Cipher.DECRYPT_MODE)
        }

        return cipher.doFinal(message).toString(Charsets.UTF_8)
    }

    fun createAPIKey(type: Algorithm): String {
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

    fun decodeAPIKey(key: String): Key {
        val decoder = Base64.getDecoder()
        val rawString = decoder.decode(key).toString(Charsets.UTF_8)
        return Gson().fromJson(rawString, Key::class.java)
    }
}

fun Cipher.initForKey(key: Key, mode: Int) {
    when (key.type) {
        Algorithm.AES_CBC_PKCS5PADDING ->
            init(mode, key.secretKey, IvParameterSpec(key.iv))
        Algorithm.AES_GCM_NoPadding -> {
            init(mode, key.secretKey, GCMParameterSpec(128, key.iv))
        }
        else -> init(mode, key.secretKey)
    }
}
