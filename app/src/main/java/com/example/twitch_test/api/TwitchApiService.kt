package com.example.twitch_test.api

//import retrofit2.converter.scalars.ScalarsConverterFactory

import com.google.gson.annotations.SerializedName
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


private const val BASE_URL = "https://api.twitch.tv/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface TwitchApiService {

    @Headers("Accept: application/vnd.twitchtv.v5+json", "Client-ID: sd4grh0omdj9a31exnpikhrmsu3v46")
    @GET("kraken/games/top")
    fun getGamesAsync(): Deferred<GameProperties>

    }


object TwitchApi {
    val retrofitService : TwitchApiService by lazy {
        retrofit.create(TwitchApiService::class.java) }
}