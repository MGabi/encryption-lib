package com.mgabbi.encryption.lib.data

import com.mgabbi.encryption.lib.Algorithm

data class Key(
    val type: Algorithm,
    val pkey: String
)