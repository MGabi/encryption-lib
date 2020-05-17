package com.mgabbi.encryption.lib

import kotlin.random.Random

enum class Algorithm {
    AES,
    AES_GCM_NoPadding,
    AES_CBC_PKCS5PADDING,
    BLOWFISH,
    DES,
    DESede;

    val keySize
        get() = when (this) {
            BLOWFISH,
            AES,
            AES_GCM_NoPadding,
            AES_CBC_PKCS5PADDING -> 256
            DES -> 56
            DESede -> 168
        }
}

fun Algorithm.keyString() = this.toString().replace("_", "/")
fun Algorithm.mainAlgorithm() = this.toString().substringBefore("_")
fun Algorithm.randomIV(): ByteArray? {
    val bytes = when (this) {
        Algorithm.DES,
        Algorithm.DESede,
        Algorithm.BLOWFISH,
        Algorithm.AES -> null
        Algorithm.AES_CBC_PKCS5PADDING -> 16
        Algorithm.AES_GCM_NoPadding -> 16
    }

    bytes ?: return null

    return Random.nextBytes(bytes)
}
