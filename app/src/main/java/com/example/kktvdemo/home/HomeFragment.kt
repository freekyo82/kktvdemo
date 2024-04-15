package com.example.kktvdemo.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kktvdemo.R
import com.example.kktvdemo.com.example.kktvdemo.adapter.ArtistAdapter
import com.example.kktvdemo.com.example.kktvdemo.common.viewBinding
import com.example.kktvdemo.com.example.kktvdemo.home.HomeViewModel
import com.example.kktvdemo.databinding.HomeFragmentBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.home_fragment) {

    private val binding by viewBinding(HomeFragmentBinding::bind)
    private val viewModel by viewModel<HomeViewModel>()
    private val artistAdapter = ArtistAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.apply {
            adapter = artistAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getSearchResult().collect {
                artistAdapter.submitData(it)

            }
        }
    }
}