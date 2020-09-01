package com.example.moviemvvmapp.activities.main.di

import com.example.moviemvvmapp.activities.main.viewModel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule = module {

    viewModel {
        MovieViewModel(get())
    }

}