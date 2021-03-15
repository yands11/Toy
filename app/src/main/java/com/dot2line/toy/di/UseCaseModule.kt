package com.dot2line.toy.di

import com.dot2line.toy.domain.GetPokeListUseCase
import com.dot2line.toy.domain.PokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
//@InstallIn(value = [ViewModelComponent::class])
@InstallIn(value = [SingletonComponent::class])
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetPokeListUseCase(repository: PokeRepository) =
        GetPokeListUseCase(repository)
}
