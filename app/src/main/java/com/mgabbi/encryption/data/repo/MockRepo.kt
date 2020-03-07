package com.mgabbi.encryption.data.repo

import com.mgabbi.encryption.data.api.MockAPI
import org.koin.core.KoinComponent
import org.koin.core.inject

class MockRepo : KoinComponent {
    private val api by inject<MockAPI>()

    suspend fun getMockList() = api.getList()
}
