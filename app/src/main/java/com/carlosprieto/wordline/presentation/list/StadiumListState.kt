package com.carlosprieto.wordline.presentation.list

import com.carlosprieto.wordline.data.remote.response.StadiumListResponse

data class StadiumListState(
    val isLoading: Boolean = false,
    val data: StadiumListResponse = StadiumListResponse(emptyList()),
    val errorMessage: String = ""
)
