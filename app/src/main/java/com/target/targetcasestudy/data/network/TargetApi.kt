package com.target.targetcasestudy.data.network

import com.target.targetcasestudy.data.models.DealItemResponse
import com.target.targetcasestudy.data.models.DealsListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TargetApi {

    @GET("deals")
    suspend fun getDeals(): DealsListResponse

    @GET("deals/{id}")
    suspend fun getDealItem(@Path("id") id: Int): DealItemResponse
}