package com.multithread.dindinntest.base

import io.reactivex.Scheduler

interface SchedulerProvider {

    val ioScheduler: Scheduler
    val mainScheduler: Scheduler
    val computation: Scheduler

}