package com.carlosprieto.wordline.presentation.details

import com.carlosprieto.wordline.domain.model.StadiumDetails

data class StadiumDetailsState(
    val isLoading: Boolean = false,
    val data: StadiumDetails? = null,
    val errorMessage: String = ""
)
