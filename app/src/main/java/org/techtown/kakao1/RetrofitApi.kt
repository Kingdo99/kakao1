package org.techtown.kakao1

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object RetrofitApi {

    private const val BASE_URL = "https://api.corona-19.kr/"

    private val okHttpClient: OkHttpClient by lazy{
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
    }

    val emgMedService: EmgMedService by lazy {
        retrofit.create(EmgMedService::class.java)
    }

    val emgMedService2: EmgMedService2 by lazy{
        retrofit.create(EmgMedService2::class.java)
    }
}