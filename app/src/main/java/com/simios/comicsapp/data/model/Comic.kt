package com.simios.comicsapp.data.model

import com.google.gson.annotations.SerializedName

data class Comic(
    @SerializedName("month") val month: String,
    @SerializedName("num") val num: Number,
    @SerializedName("link") val link: String,
    @SerializedName("year") val year: String,
    @SerializedName("safe_title") val safeTitle: String,
    @SerializedName("transcript") val transcript: String,
    @SerializedName("alt") val alt: String,
    @SerializedName("img") val img: String,
    @SerializedName("title") val title: String,
    @SerializedName("day") val day: String,
) {
}