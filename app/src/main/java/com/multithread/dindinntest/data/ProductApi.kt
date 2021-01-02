package com.multithread.dindinntest.data

import com.multithread.dindinntest.data.dto.CategoryDTO
import com.multithread.dindinntest.data.dto.VenueDTO
import io.reactivex.Single
import retrofit2.http.GET

interface ProductApi{
    @GET("/venue")
    fun getVenueList(): Single<List<VenueDTO>>
    @GET("/category")
    fun getCategoryList(): Single<List<CategoryDTO>>
}

