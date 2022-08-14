package com.example.movies.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    class MainScreen() : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainFragment.newInstance()
        }
    }
    class DetailsScreen(private val movieId: Int) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return DetailsFragment.newInstance(movieId)
        }
    }
}