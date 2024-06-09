package com.carlosprieto.wordline.domain.model

data class StadiumDetails (
    val id: String,
    val name: String,
    val description: String,
    val firstDataDate: String,
    val lastDataDate: String,
    val symbol: String,
    val type: String
)