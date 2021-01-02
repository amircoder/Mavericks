package com.multithread.dindinntest.base

import android.util.Log
import com.multithread.dindinntest.AppConstant
import io.reactivex.Single

interface BaseUseCase<PARAMS : Param, result> {
    fun execute(params: PARAMS, strategy: RepositoryStrategy): result
}

interface SingleUseCase<PARAMS : Param, RESULT> :
    BaseUseCase<PARAMS, Single<ResultResponse<RESULT>>>


abstract class ObservableUseCase<PARAMS : Param, result>
    (
    private val scheduler: SchedulerProvider,
    private val errorContainer: ErrorContainer
) :
    SingleUseCase<PARAMS, result> {


    protected abstract fun buildSingle(
        params: PARAMS,
        strategy: RepositoryStrategy
    ): Single<ResultResponse<result>>


    override fun execute(
        params: PARAMS,
        strategy: RepositoryStrategy
    ): Single<ResultResponse<result>> =
        buildSingle(params, strategy)
            .doOnError {
                for (elem in it.stackTrace) {
                    Log.e(AppConstant.ERROR_TAG, elem.toString())
                }
            }.onErrorReturn { ResultResponse.Failure(errorContainer.getError(it)) }
            .subscribeOn(scheduler.ioScheduler)
            .observeOn(scheduler.mainScheduler)

}