package com.example.moviemvvmapp.backend

import com.example.moviemvvmapp.activities.main.data.MovieCollection
import retrofit2.http.GET
import retrofit2.http.Query


interface ServiceUtil {

    @GET(value = "popular")
    suspend fun popularMovies(
        @Query(
            value = "api_key",
            encoded = false
        ) apiKey: String, @Query(value = "page") pageNumber: Int = 1
    ): MovieCollection
}