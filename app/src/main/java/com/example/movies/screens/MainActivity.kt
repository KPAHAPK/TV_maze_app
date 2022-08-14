package com.example.movies.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies.adapter.TvShowAdapter
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        setUpRv()
    }

    private fun setUpRv() {
        tvShowAdapter = TvShowAdapter()
        binding.rvTvShows.apply {
            layoutManager = GridLayoutManager(
                this@MainActivity,2,
                GridLayoutManager.VERTICAL,
                false
            )
            adapter = tvShowAdapter
            setHasFixedSize(true)
        }

        viewModel.responseTvShow.observe(this){ listTvShows ->
            tvShowAdapter.tvShows = listTvShows
        }

    }
}