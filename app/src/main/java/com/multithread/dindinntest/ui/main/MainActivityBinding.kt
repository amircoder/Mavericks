package com.multithread.dindinntest.ui.main

import com.multithread.dindinntest.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBinding {
    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindsMainActivity(): MainActivity
}