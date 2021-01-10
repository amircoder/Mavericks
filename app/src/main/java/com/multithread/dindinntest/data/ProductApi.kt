package com.multithread.dindinntest.data

import com.multithread.dindinntest.data.dto.VenueDTO
import io.reactivex.Single
import retrofit2.http.GET

interface ProductApi{
    @GET("NJ8AyaQAt")
    fun getVenueList(): Single<List<VenueDTO>>
}

