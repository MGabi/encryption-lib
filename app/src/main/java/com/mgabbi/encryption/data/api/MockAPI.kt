package com.mgabbi.encryption.data.api

import com.mgabbi.encryption.data.models.MockItem
import retrofit2.http.GET

interface MockAPI {
    @GET("items")
    suspend fun getList(): List<MockItem>
}
