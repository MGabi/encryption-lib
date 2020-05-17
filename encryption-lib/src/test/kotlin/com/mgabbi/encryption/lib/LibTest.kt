package com.mgabbi.encryption.lib

import kotlin.test.Test
import kotlin.test.assertEquals

class LibTest {

    @Test
    fun testBLOWFISH() {
        with(Encryption) {
            init(createAPIKey(Algorithm.BLOWFISH))
            testEncryptionDecryption()
        }
    }

    @Test
    fun testAES() {
        with(Encryption) {
            init(createAPIKey(Algorithm.AES))
            testEncryptionDecryption()
        }
    }

    @Test
    fun testAES_GCM_NOPADDING() {
        with(Encryption) {
            init(createAPIKey(Algorithm.AES_GCM_NoPadding))
            testEncryptionDecryption()
        }
    }

    @Test
    fun testAES_CBC_PKCS5PADDING() {
        with(Encryption) {
            init(createAPIKey(Algorithm.AES_CBC_PKCS5PADDING))
            testEncryptionDecryption()
        }
    }

    @Test
    fun testDES() {
        with(Encryption) {
            init(createAPIKey(Algorithm.DES))
            testEncryptionDecryption()
        }
    }

    @Test
    fun testDESede() {
        with(Encryption) {
            init(createAPIKey(Algorithm.DESede))
            testEncryptionDecryption()
        }
    }

    private fun testEncryptionDecryption() {
        val message = "My Message"
        val enc = Encryption.encode(message)
        val decoded = Encryption.decode(enc)
        assertEquals(message, decoded)
    }
}