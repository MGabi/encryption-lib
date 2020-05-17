package com.mgabbi.encryption.data.api

import com.google.gson.GsonBuilder
import com.mgabbi.encryption.BuildConfig
import com.mgabbi.encryption.data.api.interceptors.DecryptionInterceptor
import com.mgabbi.encryption.data.api.interceptors.EncryptionInterceptor
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TIMEOUT = 30L

object ApiProvider {

    fun provideMockAPI(): MockAPI = retrofit.create(MockAPI::class.java)

    private val gsonConverterFactory: GsonConverterFactory = let {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        GsonConverterFactory.create(gson)
    }

    private val okHttpClient: OkHttpClient = let {
        val client = OkHttpClient.Builder()
            .addInterceptor(EncryptionInterceptor())
            .addInterceptor(DecryptionInterceptor())
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            client.addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        }
        client.build()
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
}
