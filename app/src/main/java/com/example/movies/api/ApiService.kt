package com.example.movies.api

import com.example.movies.helper.Constants
import com.example.movies.model.TvShowsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowsResponse>
}