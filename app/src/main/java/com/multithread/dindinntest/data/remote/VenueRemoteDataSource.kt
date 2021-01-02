package com.multithread.dindinntest.data.remote

import com.multithread.dindinntest.base.BaseDataSource
import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.base.ResultResponse
import com.multithread.dindinntest.data.ProductApi
import com.multithread.dindinntest.data.dto.VenueDTO
import com.multithread.dindinntest.domain.entity.VenueEntity
import io.reactivex.Single
import javax.inject.Inject

interface VenueRemoteDataSource : BaseDataSource {
    fun getVenueList(): Single<List<VenueEntity>>
}

class VenueRemoteDataSourceImpl @Inject constructor(
    private val api: ProductApi,
    private val mapper: OneWayMapper<List<VenueDTO>, List<VenueEntity>>
) : VenueRemoteDataSource {
    override fun getVenueList(): Single<List<VenueEntity>> =
        api.getVenueList().map {
            mapper.map(it)
        }
}