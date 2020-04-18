package com.mgabbi.encryption.lib.data

import com.mgabbi.encryption.lib.Algorithm
import java.util.Base64
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

data class Key(
    val type: Algorithm,
    val pkey: String
) {
    val secretKey: SecretKey
        get() {
            val decodedKey = Base64.getDecoder().decode(pkey)
            return SecretKeySpec(decodedKey, 0, decodedKey.size, type.toString())
        }
}
