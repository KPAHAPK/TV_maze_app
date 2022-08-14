package com.example.movies.repository

import com.example.movies.model.MovieResponse
import retrofit2.Response

interface TvShowsRepository {
    suspend fun getMovies(): Response<MovieResponse>
}