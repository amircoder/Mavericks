package com.multithread.dindinntest.domain.usecase

import com.multithread.dindinntest.base.*
import com.multithread.dindinntest.domain.entity.CategoryEntity
import io.reactivex.Single
import javax.inject.Inject

typealias categoryRepositoryAlis = SingleBaseRepository<List<CategoryEntity>>

class CategoryUseCase @Inject constructor(
    private val repository: categoryRepositoryAlis,
    schedulerProvider: SchedulerProvider,
    errorContainer: ErrorContainer
): SingleUseCase<AnyParam, List<CategoryEntity>>(schedulerProvider, errorContainer) {
    override fun buildSingle(
        params: AnyParam,
        strategy: RepositoryStrategy
    ): Single<ResultResponse<List<CategoryEntity>>> = repository.getResult()

}