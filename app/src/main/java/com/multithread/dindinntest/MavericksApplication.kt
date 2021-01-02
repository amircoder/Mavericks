package com.multithread.dindinntest

import com.multithread.dindinntest.di.AppComponent
import com.multithread.dindinntest.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MavericksApplication: DaggerApplication(){
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent


}