package com.mgabbi.encryption.lib

enum class Algorithm {
    AES,
    BLOWFISH,
    DES,
    DESede;

    val keySize
        get() = when (this) {
            AES -> 256
            BLOWFISH -> 256
            DES -> 56
            DESede -> 168
        }
}
