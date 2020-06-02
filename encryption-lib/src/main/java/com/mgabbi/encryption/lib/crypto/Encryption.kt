package com.mgabbi.encryption.lib.crypto

object Encryption {

    private lateinit var encryption: IEncryption
    fun init(keyStr: String) {
        encryption = EncryptionImpl(keyStr)
    }

    fun encrypt(message: String) = encryption.encrypt(message)

    fun decrypt(message: ByteArray) = encryption.decrypt(message)
}
