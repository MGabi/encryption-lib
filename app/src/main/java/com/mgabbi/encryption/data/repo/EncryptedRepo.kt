package com.mgabbi.encryption.data.repo

import com.mgabbi.encryption.data.api.EncryptedApi
import com.mgabbi.encryption.data.models.SimpleRequest
import org.koin.core.KoinComponent
import org.koin.core.inject

class EncryptedRepo : KoinComponent {
    private val api by inject<EncryptedApi>()

    suspend fun sendMessage(message: SimpleRequest) = api.sendMessage(message)
}
