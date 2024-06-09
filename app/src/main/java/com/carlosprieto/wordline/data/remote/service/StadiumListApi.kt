package com.carlosprieto.wordline.data.remote.service

import com.carlosprieto.wordline.data.remote.response.StadiumItemResponse
import com.carlosprieto.wordline.data.remote.response.StadiumListResponse
import retrofit2.http.GET

interface StadiumListApi {
    @GET("/worldline-spain/technical_test_backend/main/pois.json")
    suspend fun getStadiumsList(): StadiumListResponse

//    @GET("/v1/coins/{coinId}")
//    suspend fun getCoinDetailsById(@Path("coinId") coinId: String): CoinDetailsResponse
}