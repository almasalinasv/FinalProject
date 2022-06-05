package com.example.finalproject.remote

import com.google.gson.annotations.SerializedName

class ProductEntry (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Float,
    @SerializedName("description")
    val description: String,
    @SerializedName("rating")
    val rating: RatingEntry
            )

 data class RatingEntry(
    @SerializedName("rate")
    val rate:Float
)