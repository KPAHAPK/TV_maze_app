package com.example.movies.di

import com.example.movies.repository.TvShowsRepositoryImpl
import com.example.movies.repository.TvShowsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTvShowsRepository(tvShowRepositoryImpl: TvShowsRepositoryImpl): TvShowsRepository
}