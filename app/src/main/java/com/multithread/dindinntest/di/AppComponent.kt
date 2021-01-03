package com.multithread.dindinntest.di

import android.app.Application
import com.multithread.dindinntest.ui.main.MainActivityBinding
import com.multithread.dindinntest.ui.venue.VenueFragmentBinding
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidModule::class,
        DataSourceModule::class,
        MapperModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        MainActivityBinding::class,
        VenueFragmentBinding::class,
        AppAssistedModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)
}