package com.multithread.dindinntest.util

import com.multithread.dindinntest.base.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AppSchedulerProvider @Inject constructor() : SchedulerProvider {
    override val ioScheduler: Scheduler = Schedulers.io()
    override val mainScheduler: Scheduler = AndroidSchedulers.mainThread()
    override val computation: Scheduler = Schedulers.computation()

}