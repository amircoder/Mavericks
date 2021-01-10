package com.multithread.dindinntest.di

import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.mapper.VenueMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun bindVenueMapper(): OneWayMapper<List<VenueDTO>, List<VenueEntity>> = VenueMapper()

    @Provides
    fun bindCategoryMapper(): OneWayMapper<List<CategoryDTO>, List<CategoryEntity>> =
        CategoryMapper()

}