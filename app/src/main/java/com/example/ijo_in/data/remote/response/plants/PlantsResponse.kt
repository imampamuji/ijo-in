package com.example.ijo_in.data.remote.response.plants


import com.google.gson.annotations.SerializedName

data class PlantsResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("links")
    val links: LinksX,
    @SerializedName("meta")
    val meta: Meta
)