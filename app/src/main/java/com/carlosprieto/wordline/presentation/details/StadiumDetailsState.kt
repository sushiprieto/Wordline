package com.carlosprieto.wordline.presentation.details

import com.carlosprieto.wordline.data.remote.response.StadiumItemResponse

data class StadiumDetailsState(
    val isLoading: Boolean = false,
    val data: StadiumItemResponse? = null,
    val errorMessage: String = ""
)
