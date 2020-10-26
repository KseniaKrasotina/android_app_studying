package com.example.twitch_test.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.example.twitch_test.R
import com.example.twitch_test.databinding.FragmentHomeBinding

class HomeFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val application = requireNotNull(this.activity).application

        binding.lifecycleOwner = this

        binding.homeViewModel = homeViewModel

        val adapter = GamesAdapter()
        binding.gamesListRV.adapter = adapter

        homeViewModel.getTopGames()

       homeViewModel.games.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it.top!!

            }
        })


        return binding.root
    }

}