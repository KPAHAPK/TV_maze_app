package com.example.movies.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movies.R

class DetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    companion object {
        const val ARG_PARAM_MOVIE_ID = "ARG_PARAM_MOVIE_ID"
        @JvmStatic
        fun newInstance(movieId: Int) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM_MOVIE_ID, movieId)
                }
            }
    }
}