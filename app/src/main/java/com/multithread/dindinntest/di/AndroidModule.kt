package com.multithread.dindinntest.di

import android.app.Application
import android.content.Context
import com.multithread.dindinntest.base.SchedulerProvider
import com.multithread.dindinntest.util.AppSchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class AndroidModule {

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    fun providesAppScheduler(): SchedulerProvider = AppSchedulerProvider()
}
