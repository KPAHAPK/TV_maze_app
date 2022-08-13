package com.example.movies.repository

import com.example.movies.model.TvShowsResponse
import retrofit2.Response

interface TvShowsRepository {
    suspend fun getTvShows(): Response<TvShowsResponse>
}