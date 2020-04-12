package com.mgabbi.encryption.lib

import kotlin.test.Test
import kotlin.test.assertEquals

class EncryptionTest {

    @Test
    fun testEncryption() {
        val encryption = Encryption()
        val message = "test"
        println(encryption.encrypt(message))
        val encrypted = encryption.encrypt(message)
        assertEquals(encryption.decrypt(encrypted), "test")
    }
}