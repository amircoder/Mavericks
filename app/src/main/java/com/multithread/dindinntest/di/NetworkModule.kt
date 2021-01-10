package com.multithread.dindinntest.di

import android.content.Context
import androidx.annotation.NonNull
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.multithread.dindinntest.BuildConfig
import com.multithread.dindinntest.base.ErrorContainer
import com.multithread.dindinntest.data.ProductApi
import com.multithread.dindinntest.util.GeneralHandlerImpl
import com.multithread.dindinntest.util.ImageLoader
import com.multithread.dindinntest.util.ImageLoaderImpl
import com.multithread.dindinntest.util.NetworkInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(context: Context): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(NetworkInterceptor())
                    .cache(null)
                    .writeTimeout(8, TimeUnit.SECONDS)
                    .callTimeout(8, TimeUnit.SECONDS)
                    .connectTimeout(8, TimeUnit.SECONDS)
                    .readTimeout(8, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG)
                            HttpLoggingInterceptor.Level.BODY
                        else
                            HttpLoggingInterceptor.Level.NONE
                    }).build()

    @Provides
    @Singleton
    fun provideRetrofit(
            @NonNull client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    fun provideErrorHandler(errorHandler: GeneralHandlerImpl): ErrorContainer = errorHandler

    @Provides
    fun provideImageLoader(imageLoader: ImageLoaderImpl): ImageLoader = imageLoader

    @Provides
    fun provideApi(@NonNull retrofit: Retrofit) = retrofit.create(ProductApi::class.java)
}