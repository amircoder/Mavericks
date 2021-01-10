package com.multithread.dindinntest.util

import com.multithread.dindinntest.base.SchedulerProvider
import com.twistedequations.rx2.AndroidRxSchedulers
import io.reactivex.Scheduler
import javax.inject.Inject


class AppSchedulerProvider @Inject constructor(
    androidRxSchedulers: AndroidRxSchedulers
) : SchedulerProvider {
    override val ioScheduler: Scheduler = androidRxSchedulers.io()
    override val mainScheduler: Scheduler = androidRxSchedulers.mainThread()
    override val computation: Scheduler = androidRxSchedulers.computation()

}