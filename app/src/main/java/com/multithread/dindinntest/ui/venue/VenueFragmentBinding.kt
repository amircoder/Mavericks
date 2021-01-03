package com.multithread.dindinntest.ui.venue

import com.multithread.dindinntest.di.scope.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class VenueFragmentBinding {
    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindsVenueFragment(): VenueFragment
}