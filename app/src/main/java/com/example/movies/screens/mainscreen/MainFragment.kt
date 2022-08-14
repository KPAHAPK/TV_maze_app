package com.example.movies.screens.mainscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movies.R
import com.example.movies.databinding.FragmentMainBinding
import com.example.movies.screens.mainscreen.adapter.TvShowAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::class.java)
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()
    }

    private fun setUpRv() {
        tvShowAdapter = TvShowAdapter { tvShowsItem ->
            viewModel.routeToDetailsScreen(tvShowsItem)
        }

        binding.rvTvShows.apply {
            layoutManager = GridLayoutManager(
                this@MainFragment.context, 2,
                GridLayoutManager.VERTICAL,
                false
            )
            adapter = tvShowAdapter
            setHasFixedSize(true)
        }

        viewModel.responseTvShow.observe(viewLifecycleOwner) { listTvShows ->
            tvShowAdapter.tvShows = listTvShows
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}