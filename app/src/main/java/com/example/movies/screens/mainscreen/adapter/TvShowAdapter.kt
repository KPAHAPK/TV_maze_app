package com.example.movies.screens.mainscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movies.databinding.TvShowItemBinding
import com.example.movies.model.MovieItem

class TvShowAdapter(private val onItemClicked: (MovieItem) -> Unit) : RecyclerView.Adapter<TvShowAdapter.TvShowVH>() {

    inner class TvShowVH(val binding: TvShowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowItem: MovieItem) {
            binding.apply {
                textViewNameTvShow.text = tvShowItem.name
                imageViewTvShow.load(tvShowItem.image.original){
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowVH {
        val binding = TvShowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowVH(binding)
    }

    override fun onBindViewHolder(holder: TvShowVH, position: Int) {
        val item = tvShows[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClicked(item) }
    }

    override fun getItemCount() = tvShows.size

    private val diffCallback = object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var tvShows: List<MovieItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)
}
