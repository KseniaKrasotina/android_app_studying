package com.example.twitch_test.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twitch_test.api.GameProperties
import com.example.twitch_test.api.TwitchApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    private val _games = MutableLiveData<GameProperties>()

    val games: LiveData<GameProperties>
        get() = _games
    init {
        _games.value = null
    }

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )


    fun getTopGames() {
        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            var topGames = TwitchApi.retrofitService.getGamesAsync()
            try {
                // Await the completion of our Retrofit request
                var listResult = topGames.await()
                _response.value = "Success: ${listResult} games retrieved"
                _games.value = listResult
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"

            }
        }
    }
}