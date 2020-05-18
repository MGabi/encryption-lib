package com.mgabbi.encryption.lib.key

import com.mgabbi.encryption.lib.Algorithm

object KeyUtils {

    private val keyUtils: IKeyUtils = KeyUtilsImpl()

    fun createAPIKey(type: Algorithm) = keyUtils.createAPIKey(type)
}