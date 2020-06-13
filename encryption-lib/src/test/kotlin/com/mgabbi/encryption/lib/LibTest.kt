package com.mgabbi.encryption.lib

import com.mgabbi.encryption.lib.crypto.Encryption
import com.mgabbi.encryption.lib.key.KeyUtils
import java.security.Provider
import java.security.Security
import kotlin.test.Test
import kotlin.test.assertEquals

class LibTest {

    @Test
    fun testBLOWFISH() {
        Encryption.init(KeyUtils.createAPIKey(Algorithm.BLOWFISH))
        testEncryptionDecryption()
    }

    @Test
    fun testAES() {
        Encryption.init(KeyUtils.createAPIKey(Algorithm.AES))
        testEncryptionDecryption()
    }

    @Test
    fun testAES_GCM_NOPADDING() {
        Encryption.init(KeyUtils.createAPIKey(Algorithm.AES_GCM_NoPadding))
        testEncryptionDecryption()
    }

    @Test
    fun testAES_CBC_PKCS5PADDING() {
        Encryption.init(KeyUtils.createAPIKey(Algorithm.AES_CBC_PKCS5PADDING))
        testEncryptionDecryption()
    }

    @Test
    fun testDES() {
        Encryption.init(KeyUtils.createAPIKey(Algorithm.DES))
        testEncryptionDecryption()
    }

    @Test
    fun testDESede() {
        Encryption.init(KeyUtils.createAPIKey(Algorithm.DESede))
        testEncryptionDecryption()
    }

    private fun testEncryptionDecryption() {
        val message = "My Message"
        val enc = Encryption.encrypt(message)
        val decoded = Encryption.decrypt(enc)
        assertEquals(message, decoded)
    }
}