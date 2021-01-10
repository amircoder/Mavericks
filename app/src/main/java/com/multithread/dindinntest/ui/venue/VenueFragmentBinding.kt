package com.multithread.dindinntest.ui.venue

import com.multithread.dindinntest.di.scope.PerFragment
import com.multithread.dindinntest.ui.venue.category.CategoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class VenueFragmentBinding {
    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindsVenueFragment(): VenueFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindsCategoryFragment(): CategoryFragment
}