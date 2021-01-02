package com.multithread.dindinntest.di

import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.data.dto.CategoryDTO
import com.multithread.dindinntest.data.dto.VenueDTO
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.mapper.CategoryMapper
import com.multithread.dindinntest.mapper.VenueMapper
import dagger.Binds
import dagger.Module

@Module
interface MapperModule {

    @Binds
    fun bindVenueMapper(mapper: VenueMapper): OneWayMapper<List<VenueDTO>, List<VenueEntity>>

    @Binds
    fun bindCategoryMapper(mapper: CategoryMapper): OneWayMapper<List<CategoryDTO>, List<CategoryEntity>>

}