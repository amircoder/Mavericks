package com.multithread.dindinntest.di

import com.multithread.dindinntest.base.*
import com.multithread.dindinntest.data.dto.DeliveryDTO
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.domain.usecase.VenueUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun bindsVenueUseCase(
        repository: SingleBaseRepository<List<VenueEntity>>,
        schedulerProvider: SchedulerProvider,
        errorContainer: ErrorContainer
    ): SingleUseCase<AnyParam, List<VenueEntity>> = VenueUseCase(
        repository,
        schedulerProvider,
        errorContainer
    )


}