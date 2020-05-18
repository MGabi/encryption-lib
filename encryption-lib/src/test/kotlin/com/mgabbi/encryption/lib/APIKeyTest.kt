package com.mgabbi.encryption.lib

import com.mgabbi.encryption.lib.key.KeyUtilsImpl
import kotlin.test.Test
import kotlin.test.assertEquals

class APIKeyTest {

    @Test
    fun createAPIKeyTest() {
        val t = Algorithm.AES
        val utils = KeyUtilsImpl()
        val key = utils.createAPIKey(t)
        val actual = utils.decodeAPIKey(key)
        assertEquals(t, actual.type)
    }
}