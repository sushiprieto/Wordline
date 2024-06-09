package com.carlosprieto.wordline.data.remote.response

data class StadiumListResponse (
    val list: List<StadiumItemResponse>
)

data class StadiumItemResponse (
    val id: String,
    val title: String,
    val geocoordinates: String,
    val image: String
)

