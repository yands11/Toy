package com.dot2line.toy.di

import com.dot2line.toy.data.PokeRepositoryImpl
import com.dot2line.toy.domain.PokeRepository
import com.dot2line.toy.network.PokeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(value = [SingletonComponent::class])
object RepositoryModule {

    @Provides
    @Singleton
    fun providePokeRepository(pokeService: PokeService): PokeRepository =
        PokeRepositoryImpl(pokeService)
}
