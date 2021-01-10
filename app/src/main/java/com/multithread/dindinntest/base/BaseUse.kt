package com.multithread.dindinntest.base

import android.util.Log
import com.multithread.dindinntest.AppConstant
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface BaseUseCase<PARAMS : Param, result> {
    fun invokeOperation(params: PARAMS, strategy: RepositoryStrategy): result
}

interface BaseSingleUseCase<PARAMS : Param, RESULT> :
    BaseUseCase<PARAMS, Single<RESULT>>


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


    override fun invokeOperation(
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