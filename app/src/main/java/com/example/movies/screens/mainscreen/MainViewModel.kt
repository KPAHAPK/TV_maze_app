package com.example.movies.screens.mainscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.model.TvShowsItem
import com.example.movies.repository.TvShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject
constructor(
    private val tvShowsRepository: TvShowsRepository
) : ViewModel() {
    private val _response = MutableLiveData<List<TvShowsItem>>()
    val responseTvShow: LiveData<List<TvShowsItem>>
        get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        tvShowsRepository.getTvShows().let { response ->
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