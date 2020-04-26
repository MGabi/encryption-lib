package com.mgabbi.encryption.lib

import kotlin.test.Test
import kotlin.test.assertEquals

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