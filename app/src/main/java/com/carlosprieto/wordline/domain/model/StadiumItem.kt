package com.carlosprieto.wordline.domain.model

data class StadiumList (
    val list: List<StadiumItem>
)

data class StadiumItem (
    val id: String,
    val title: String,
    val geocoordinates: String,
    val image: String
)