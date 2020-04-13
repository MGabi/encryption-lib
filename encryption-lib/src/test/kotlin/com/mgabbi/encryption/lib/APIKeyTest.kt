package com.mgabbi.encryption.lib

import java.util.Base64
import kotlin.test.Test
import kotlin.test.assertEquals

class APIKeyTest {

    @Test
    fun createAPIKeyTest() {
        val t = Algorithm.AES
        val pk = "asidjai3r1389iejd"

        val result = createAPIKey(t, pk)
        val decoder = Base64.getDecoder()
        val actual = decoder.decode(result).toString(Charsets.UTF_8)
        assertEquals(
            "{\"type\":\"AES\",\"pkey\":\"asidjai3r1389iejd\"}",
            actual
        )
        println(result)
        println(actual)
    }
}