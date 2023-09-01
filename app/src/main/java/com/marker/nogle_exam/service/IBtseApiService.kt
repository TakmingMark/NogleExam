package com.marker.nogle_exam.service

import com.marker.nogle_exam.data.model.Market
import retrofit2.http.GET

interface IBtseApiService {
    @GET("futures/api/inquire/initial/market")
    suspend fun getMarket(): Market
}