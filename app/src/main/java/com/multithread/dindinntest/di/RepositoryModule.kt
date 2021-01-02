package com.multithread.dindinntest.di

import com.multithread.dindinntest.base.SingleBaseRepository
import com.multithread.dindinntest.data.remote.CategoryRemoteDataSource
import com.multithread.dindinntest.data.remote.VenueRemoteDataSource
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.domain.repository.CategoryRepository
import com.multithread.dindinntest.domain.repository.VenueRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun bindsCategoryRepository(
        categoryRemoteDataSource: CategoryRemoteDataSource
    ): SingleBaseRepository<List<CategoryEntity>> =
        CategoryRepository(categoryRemoteDataSource)

    @Provides
    fun bindsVenueRepository(
        venueRemoteDataSource: VenueRemoteDataSource
    ): SingleBaseRepository<List<VenueEntity>> = VenueRepository(venueRemoteDataSource)
}