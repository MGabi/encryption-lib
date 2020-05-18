package com.mgabbi.encryption.lib

object Encryption {

    private lateinit var encryption: IEncryption
    fun init(keyStr: String) {
        encryption = EncryptionImpl(keyStr)
    }

    fun encode(message: String) = encryption.encode(message)

    fun decode(message: ByteArray) = encryption.decode(message)
}
