package com.mgabbi.encryption.lib

import com.mgabbi.encryption.lib.data.Key
import javax.crypto.SecretKey
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LibTest {

    @Test
    fun testBLOWFISH() {
        with(Encryption) {
            val key = decodeAPIKey(createAPIKey(Algorithm.BLOWFISH))
            init(key)
            testEncryptionDecryption()
        }
    }

    @Test
    fun testAES() {
        with(Encryption) {
            val key = decodeAPIKey(createAPIKey(Algorithm.AES))
            init(key)
            testEncryptionDecryption()
        }
    }

    @Test
    fun testDES() {
        with(Encryption) {
            val key = decodeAPIKey(createAPIKey(Algorithm.DES))
            init(key)
            testEncryptionDecryption()
        }
    }

    @Test
    fun testDESede() {
        with(Encryption) {
            val key = decodeAPIKey(createAPIKey(Algorithm.DESede))
            init(key)
            testEncryptionDecryption()
        }
    }

    private fun testEncryptionDecryption() {
        val message = "abcdefgh"
        val enc = Encryption.encode(message)
        val decoded = Encryption.decode(enc)
        assertEquals(message, decoded)
    }
}