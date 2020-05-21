package com.mgabbi.encryption.data.repo

import com.mgabbi.encryption.data.api.SimpleApi
import com.mgabbi.encryption.data.models.SimpleRequest
import org.koin.core.KoinComponent
import org.koin.core.inject

class SimpleRepo : KoinComponent {
    private val api by inject<SimpleApi>()

    suspend fun sendMessageRaw(message: SimpleRequest) = api.sendMessageRaw(message)
}
