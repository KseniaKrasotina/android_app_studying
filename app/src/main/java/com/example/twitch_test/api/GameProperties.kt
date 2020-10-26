package com.example.twitch_test.api

import com.google.gson.annotations.SerializedName

data class GameProperties (
    @SerializedName("_total") val _total : Int,
    @SerializedName("top") val top : List<TopItem>?
)

data class TopItem (
    @SerializedName("channels") val channels : String,
    @SerializedName("viewers") val viewers : String,
    @SerializedName("game") val game : Game
)

data class Game (
    @SerializedName("_id") val _id : Double,
    @SerializedName("box") val box : Box,
    @SerializedName("giantbomb_id") val giantbomb_id : Int,
    @SerializedName("logo") val logo : GameLogo,
    @SerializedName("name") val name : String
    )

data class Box (
    @SerializedName("large") val large : String,
    @SerializedName("medium") val medium : String,
    @SerializedName("small") val small : String,
    @SerializedName("template") val template : String
)

data class GameLogo (
    @SerializedName("large") val large : String,
    @SerializedName("medium") val medium : String,
    @SerializedName("small") val small : String,
    @SerializedName("template") val template : String
)
