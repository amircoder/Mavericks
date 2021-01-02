package com.multithread.dindinntest.domain.usecase

import com.multithread.dindinntest.base.*
import com.multithread.dindinntest.domain.entity.VenueEntity
import io.reactivex.Single
import javax.inject.Inject


typealias venueRepositoryAlis = SingleBaseRepository<List<VenueEntity>>

class VenueUseCase @Inject constructor(
    private val repository: venueRepositoryAlis,
    schedulerProvider: SchedulerProvider,
    errorContainer: ErrorContainer
): SingleUseCase<AnyParam, List<VenueEntity>>(schedulerProvider, errorContainer){
    override fun buildSingle(
        params: AnyParam,
        strategy: RepositoryStrategy
    ): Single<List<VenueEntity>> = repository.getResult()

}