package com.mgabbi.encryption.lib

import com.mgabbi.encryption.lib.data.KeyUtils
import kotlin.test.Test
import kotlin.test.assertEquals

class APIKeyTest {

    @Test
    fun createAPIKeyTest() {
        val t = Algorithm.AES
        val key = KeyUtils.createAPIKey(t)
        val actual = KeyUtils.decodeAPIKey(key)
        assertEquals(t, actual.type)
    }
}