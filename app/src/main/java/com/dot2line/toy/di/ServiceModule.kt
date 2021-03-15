package com.dot2line.toy.di

import com.dot2line.toy.network.PokeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(value = [SingletonComponent::class])
object ServiceModule {

    @Provides
    @Singleton
    fun providePokeService(retrofit: Retrofit): PokeService =
        retrofit.create(PokeService::class.java)

}
