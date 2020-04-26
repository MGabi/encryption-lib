package com.mgabbi.encryption.lib

import com.mgabbi.encryption.lib.data.Key
import javax.crypto.Cipher

object Encryption {

    private lateinit var key: Key

    fun init(keyStr: String) {
        this.key = decodeAPIKey(keyStr)
    }

    fun encode(message: String): ByteArray {
        val cipher = Cipher.getInstance("${key.type}").apply {
            init(Cipher.ENCRYPT_MODE, key.secretKey)
        }
        return cipher.doFinal(message.toByteArray())
    }

    fun decode(message: ByteArray): String {
        val cipher = Cipher.getInstance("${key.type}").apply {
            init(Cipher.DECRYPT_MODE, key.secretKey)
        }

        return cipher.doFinal(message).toString(Charsets.UTF_8)
    }
}
