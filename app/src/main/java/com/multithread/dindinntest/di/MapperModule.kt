package com.multithread.dindinntest.di

import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.data.dto.DeliveryDTO
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.mapper.VenueMapper
import dagger.Binds
import dagger.Module

@Module
interface MapperModule {
    @Binds
    fun bindVenueMapper(mapper: VenueMapper): OneWayMapper<DeliveryDTO, VenueEntity>
}