package com.multithread.dindinntest.data

import com.multithread.dindinntest.data.dto.DeliveryDTO
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ProductApi{
    @GET("NJ8AyaQAt")
    fun getVenueList(): Single<List<DeliveryDTO>>
}

