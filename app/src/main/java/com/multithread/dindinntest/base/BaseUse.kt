package com.multithread.dindinntest.base

import android.util.Log
import com.multithread.dindinntest.AppConstant
import io.reactivex.Single

interface BaseUseCase<PARAMS : Param, result> {
    fun execute(params: PARAMS, strategy: RepositoryStrategy): result
}

interface BaseSingleUseCase<PARAMS : Param, RESULT> :
    BaseUseCase<PARAMS, Single<ResultResponse<RESULT>>>


abstract class SingleUseCase<PARAMS : Param, result>
    (
    private val scheduler: SchedulerProvider,
    private val errorContainer: ErrorContainer
) :
    BaseSingleUseCase<PARAMS, result> {


    protected abstract fun buildSingle(
        params: PARAMS,
        strategy: RepositoryStrategy
    ): Single<result>


    override fun execute(
        params: PARAMS,
        strategy: RepositoryStrategy
    ): Single<result> =
        buildSingle(params, strategy)
            .doOnError {
                for (elem in it.stackTrace) {
                    Log.e(AppConstant.ERROR_TAG, elem.toString())
                }
            }
            .subscribeOn(scheduler.ioScheduler)
            .observeOn(scheduler.mainScheduler)

}