package com.mgabbi.encryption.lib

import java.util.Base64
import kotlin.test.Test
import kotlin.test.assertEquals

class APIKeyTest {

    @Test
    fun createAPIKeyTest() {
        val t = Algorithm.AES
        val key = createAPIKey(t)
        val actual = decodeAPIKey(key)
        assertEquals(t, actual.type)
        print(actual.pkey)
    }
}