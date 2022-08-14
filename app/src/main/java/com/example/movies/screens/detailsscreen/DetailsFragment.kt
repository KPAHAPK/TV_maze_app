package com.example.movies.screens.detailsscreen

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.movies.R
import com.example.movies.databinding.FragmentDetailsBinding
import com.example.movies.model.MovieItem

class DetailsFragment : Fragment() {

    private val binding by viewBinding(FragmentDetailsBinding::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie: MovieItem? = arguments?.getParcelable(ARG_PARAM_MOVIE)
        binding.apply {
            movie?.let {
                banner.load(movie.image.original)
                poster.load(movie.image.medium)
                title.text = movie.name
                val description = Html.fromHtml(movie.summary).toString()
                descriptions.text = description
            }
        }

    }

    companion object {
        const val ARG_PARAM_MOVIE = "ARG_PARAM_MOVIE"

        @JvmStatic
        fun newInstance(movie: MovieItem) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM_MOVIE, movie)
                }
            }
    }
}