package com.mgabbi.encryption.lib

import kotlin.test.Test
import kotlin.test.assertEquals

class APIKeyTest {

    @Test
    fun createAPIKeyTest() {
        val t = Algorithm.AES
        val key = Encryption.createAPIKey(t)
        val actual = Encryption.decodeAPIKey(key)
        assertEquals(t, actual.type)
    }
}