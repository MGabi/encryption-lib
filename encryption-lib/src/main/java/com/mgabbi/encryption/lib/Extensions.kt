package com.mgabbi.encryption.lib

import com.mgabbi.encryption.lib.data.Key
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.IvParameterSpec

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
