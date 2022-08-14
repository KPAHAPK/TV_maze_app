package com.example.movies.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.movies.model.MovieItem
import com.example.movies.screens.detailsscreen.DetailsFragment
import com.example.movies.screens.mainscreen.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    class MainScreen() : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainFragment.newInstance()
        }
    }
    class DetailsScreen(private val movieId: MovieItem) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return DetailsFragment.newInstance(movieId)
        }
    }
}