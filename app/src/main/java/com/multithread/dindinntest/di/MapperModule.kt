package com.multithread.dindinntest.di

import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.data.dto.VenueDTO
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.mapper.VenueMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun bindVenueMapper(): OneWayMapper<List<VenueDTO>, List<VenueEntity>> = VenueMapper()

}