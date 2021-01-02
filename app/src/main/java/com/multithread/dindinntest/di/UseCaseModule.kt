package com.multithread.dindinntest.di

import com.multithread.dindinntest.base.*
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.domain.usecase.CategoryUseCase
import com.multithread.dindinntest.domain.usecase.VenueUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun bindsCategoryUseCase(
        repository: SingleBaseRepository<List<CategoryEntity>>,
        schedulerProvider: SchedulerProvider,
        errorContainer: ErrorContainer
    ): SingleUseCase<AnyParam, List<CategoryEntity>> =
        CategoryUseCase(repository, schedulerProvider, errorContainer)

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