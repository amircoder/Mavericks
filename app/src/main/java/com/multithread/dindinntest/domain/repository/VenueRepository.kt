package com.multithread.dindinntest.domain.repository

import com.multithread.dindinntest.base.SingleBaseRepository
import com.multithread.dindinntest.data.dto.DeliveryDTO
import com.multithread.dindinntest.data.remote.VenueRemoteDataSource
import com.multithread.dindinntest.domain.entity.VenueEntity
import io.reactivex.Single
import javax.inject.Inject

class VenueRepository @Inject constructor(
    private val venueRemoteDataSource: VenueRemoteDataSource
): SingleBaseRepository<List<VenueEntity>>(){
    override fun getResult(): Single<List<VenueEntity>> =
        venueRemoteDataSource.getVenueList()
}
