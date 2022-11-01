package com.cloudxanh.kointutorial.data.model


import com.squareup.moshi.Json

data class Album(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "userId")
    val userId: Int
)