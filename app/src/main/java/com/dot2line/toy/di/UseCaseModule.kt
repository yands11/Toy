package com.dot2line.toy.di

import com.dot2line.toy.domain.GetPokeListUseCase
import com.dot2line.toy.domain.PokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(value = [ViewModelComponent::class])
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetPokeListUseCase(repository: PokeRepository) =
        GetPokeListUseCase(repository)
}
