package com.multithread.dindinntest.di

import android.app.Application
import android.content.Context
import com.multithread.dindinntest.base.SchedulerProvider
import com.multithread.dindinntest.util.AppSchedulerProvider
import com.twistedequations.rx2.AndroidRxSchedulers
import com.twistedequations.rx2.DefaultAndroidRxSchedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule {

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Singleton
    @Provides
    fun rxSchedulers() : AndroidRxSchedulers = DefaultAndroidRxSchedulers()


    @Singleton
    @Provides
    fun provideAppScheduler(rxSchedulers: AndroidRxSchedulers): SchedulerProvider =
        AppSchedulerProvider(rxSchedulers)
}
