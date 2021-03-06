package com.example.moviemvvmapp.activities.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.moviemvvmapp.activities.main.data.MovieCollection
import com.example.moviemvvmapp.activities.main.viewHolder.MovieAdapterViewHolder
import com.squareup.picasso.Picasso


class MovieAdapter(private val picasso: Picasso) :
    ListAdapter<MovieCollection.Movie, MovieAdapterViewHolder>(
        DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieAdapterViewHolder.create(parent, picasso)

    override fun onBindViewHolder(holderAdapter: MovieAdapterViewHolder, position: Int) {
        holderAdapter.bind(getItem(position))
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieCollection.Movie>() {

            override fun areItemsTheSame(
                oldItem: MovieCollection.Movie,
                newItem: MovieCollection.Movie
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MovieCollection.Movie,
                newItem: MovieCollection.Movie
            ) =
                oldItem == newItem
        }
    }
}