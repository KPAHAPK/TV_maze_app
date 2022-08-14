package com.example.movies.screens.mainscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.model.MovieItem
import com.example.movies.repository.TvShowsRepository
import com.example.movies.screens.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject
constructor(
    private val tvShowsRepository: TvShowsRepository
) : ViewModel() {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val _response = MutableLiveData<List<MovieItem>>()
    val responseTvShow: LiveData<List<MovieItem>>
        get() = _response

    fun routeToDetailsScreen(movieItem: MovieItem){
        router.navigateTo(Screens.DetailsScreen(movieItem))
    }

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        tvShowsRepository.getMovies().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d(TAG, "getAllTvShows Error: ${response.code()}")
            }
        }
    }

    companion object {
        const val TAG = "TvShowsViewModel"
    }
}