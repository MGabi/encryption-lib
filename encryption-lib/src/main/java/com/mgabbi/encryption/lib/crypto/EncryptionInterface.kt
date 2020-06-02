package com.mgabbi.encryption.lib.crypto

import com.mgabbi.encryption.lib.data.Key
import com.mgabbi.encryption.lib.initForKey
import com.mgabbi.encryption.lib.key.KeyUtilsImpl
import com.mgabbi.encryption.lib.keyString
import javax.crypto.Cipher

interface IEncryption {

    val key: Key

    fun encrypt(message: String): ByteArray
    fun decrypt(message: ByteArray): String
}

internal class EncryptionImpl(keyStr: String) : IEncryption {
    override val key: Key = KeyUtilsImpl().decodeAPIKey(keyStr)

    override fun encrypt(message: String): ByteArray {
        val cipher = Cipher.getInstance(key.type.keyString()).apply {
            initForKey(key, Cipher.ENCRYPT_MODE)
        }
        return cipher.doFinal(message.toByteArray())
    }

    override fun decrypt(message: ByteArray): String {
        val cipher = Cipher.getInstance(key.type.keyString()).apply {
            initForKey(key, Cipher.DECRYPT_MODE)
        }

        return cipher.doFinal(message).toString(Charsets.UTF_8)
    }
}
