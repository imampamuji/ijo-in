package com.example.ijo_in.data.remote.response.plants


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("self")
    val self: String
)