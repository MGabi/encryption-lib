package com.mgabbi.encryption.lib.data

import com.mgabbi.encryption.lib.Algorithm
import com.mgabbi.encryption.lib.mainAlgorithm
import java.util.Base64
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Suppress("ArrayInDataClass")
data class Key(
    val type: Algorithm,
    val pKey: String,
    val iv: ByteArray? = null
) {
    val secretKey: SecretKey
        get() {
            val decodedKey = Base64.getDecoder().decode(pKey)
            return SecretKeySpec(decodedKey, 0, decodedKey.size, type.mainAlgorithm())
        }
}
