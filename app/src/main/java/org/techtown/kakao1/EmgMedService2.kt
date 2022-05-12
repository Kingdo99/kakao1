package org.techtown.kakao1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EmgMedService2 {

    @GET("korea/vaccine/")
    fun getEmgMedData(@Query("serviceKey") serviceKey : String): Call<EmgMedResponse2>
}