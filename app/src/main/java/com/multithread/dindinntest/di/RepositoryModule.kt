package com.multithread.dindinntest.di

import com.multithread.dindinntest.base.SingleBaseRepository
import com.multithread.dindinntest.data.dto.DeliveryDTO
import com.multithread.dindinntest.data.remote.VenueRemoteDataSource
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.domain.repository.VenueRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun bindsVenueRepository(
        venueRemoteDataSource: VenueRemoteDataSource
    ): SingleBaseRepository<List<VenueEntity>> = VenueRepository(venueRemoteDataSource)

}