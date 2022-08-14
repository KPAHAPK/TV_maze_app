package com.example.movies.repository

import com.example.movies.api.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TvShowsRepository {

    override suspend fun getMovies() = apiService.getTvShows()

}