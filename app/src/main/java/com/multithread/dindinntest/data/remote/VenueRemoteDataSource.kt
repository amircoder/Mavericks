package com.multithread.dindinntest.data.remote

import com.multithread.dindinntest.BuildConfig
import com.multithread.dindinntest.base.BaseDataSource
import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.data.ProductApi
import com.multithread.dindinntest.data.dto.VenueDTO
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.util.DataHelper
import io.reactivex.Single
import javax.inject.Inject

interface VenueRemoteDataSource : BaseDataSource {
    fun getVenueList(): Single<List<VenueEntity>>
}

class VenueRemoteDataSourceImpl @Inject constructor(
    private val api: ProductApi,
    private val mapper: OneWayMapper<List<VenueDTO>, List<VenueEntity>>
) : VenueRemoteDataSource {
    override fun getVenueList(): Single<List<VenueEntity>> = if (BuildConfig.DEMO) {
        Single.just(
            listOf(DataHelper.createVenueEntity())
        )
    } else {
        api.getVenueList().map {
            mapper.map(it)
        }
    }
}