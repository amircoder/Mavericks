package com.multithread.dindinntest

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MavericksApplication: DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("Not yet implemented")
    }

}