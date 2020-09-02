package com.example.moviemvvmapp.activities.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviemvvmapp.R
import com.example.moviemvvmapp.activities.main.data.MovieCollection
import com.example.moviemvvmapp.backend.ServiceUtil
import com.example.moviemvvmapp.util.Constants
import com.example.moviemvvmapp.util.Event
import kotlinx.coroutines.launch

class MovieViewModel constructor(private val serviceUtil: ServiceUtil) : ViewModel() {

    private val _uiState = MutableLiveData<MovieDataState>()
    val uiState: LiveData<MovieDataState> get() = _uiState

    init {
        retrieveMovies()
    }

    private fun retrieveMovies() {
        viewModelScope.launch {
            runCatching {
                emitUiState(showProgress = true)
                serviceUtil.popularMovies(apiKey = Constants.API_KEY)
            }.onSuccess {
                emitUiState(movies = Event(it.movies))
            }.onFailure {
                it.printStackTrace()
                emitUiState(error = Event(R.string.error))
            }
        }
    }

    private fun emitUiState(
        showProgress: Boolean = false,
        movies: Event<List<MovieCollection.Movie>>? = null,
        error: Event<Int>? = null
    ) {
        val dataState = MovieDataState(showProgress, movies, error)
        _uiState.value = dataState
    }
}

data class MovieDataState(
    val showProgress: Boolean,
    val movies: Event<List<MovieCollection.Movie>>?,
    val error: Event<Int>?
)