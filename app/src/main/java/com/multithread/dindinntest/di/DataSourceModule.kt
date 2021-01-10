package com.multithread.dindinntest.di


import com.multithread.dindinntest.data.remote.VenueRemoteDataSource
import com.multithread.dindinntest.data.remote.VenueRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {
    @Binds
    fun bindsVenueDataSource(dataSource: VenueRemoteDataSourceImpl): VenueRemoteDataSource
}