package com.mgabbi.encryption.lib

import com.mgabbi.encryption.lib.data.Key
import com.mgabbi.encryption.lib.data.KeyUtils
import javax.crypto.Cipher

interface IEncryption {

    val key: Key

    fun encode(message: String): ByteArray
    fun decode(message: ByteArray): String
}

internal class EncryptionImpl(keyStr: String) : IEncryption {
    override val key: Key = KeyUtils.decodeAPIKey(keyStr)

    override fun encode(message: String): ByteArray {
        val cipher = Cipher.getInstance(key.type.keyString()).apply {
            initForKey(key, Cipher.ENCRYPT_MODE)
        }
        return cipher.doFinal(message.toByteArray())
    }

    override fun decode(message: ByteArray): String {
        val cipher = Cipher.getInstance(key.type.keyString()).apply {
            initForKey(key, Cipher.DECRYPT_MODE)
        }

        return cipher.doFinal(message).toString(Charsets.UTF_8)
    }
}

