package com.multithread.dindinntest.di

import com.multithread.dindinntest.data.remote.CategoryRemoteDataSource
import com.multithread.dindinntest.data.remote.CategoryRemoteDataSourceImpl
import com.multithread.dindinntest.data.remote.VenueRemoteDataSource
import com.multithread.dindinntest.data.remote.VenueRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {
    @Binds
    fun bindsCategoryDataSource(dataSource: CategoryRemoteDataSourceImpl): CategoryRemoteDataSource

    @Binds
    fun bindsVenueDataSource(dataSource: VenueRemoteDataSourceImpl): VenueRemoteDataSource
}