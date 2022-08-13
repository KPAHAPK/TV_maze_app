package com.example.movies.repository

import com.example.movies.api.ApiService
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TvShowsRepository {

    override suspend fun getTvShows() = apiService.getTvShows()

}