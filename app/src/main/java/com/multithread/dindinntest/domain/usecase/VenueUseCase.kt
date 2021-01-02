package com.multithread.dindinntest.domain.usecase

import com.multithread.dindinntest.base.*
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.domain.repository.VenueRepository
import io.reactivex.Single
import javax.inject.Inject

class VenueUseCase @Inject constructor(
    private val repository: VenueRepository,
    schedulerProvider: SchedulerProvider,
    errorContainer: ErrorContainer
): ObservableUseCase<AnyParam, List<VenueEntity>>(schedulerProvider, errorContainer){
    override fun buildSingle(
        params: AnyParam,
        strategy: RepositoryStrategy
    ): Single<ResultResponse<List<VenueEntity>>> = repository.getResult()

}