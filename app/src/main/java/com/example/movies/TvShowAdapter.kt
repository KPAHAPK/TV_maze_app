package com.example.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movies.databinding.TvShowItemBinding
import com.example.movies.model.TvShowsItem

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowVH>() {

    inner class TvShowVH(val binding: TvShowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowItem: TvShowsItem) {
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
        holder.bind(tvShows[position])
    }

    override fun getItemCount() = tvShows.size

    private val diffCallback = object : DiffUtil.ItemCallback<TvShowsItem>() {
        override fun areItemsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var tvShows: List<TvShowsItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)
}
