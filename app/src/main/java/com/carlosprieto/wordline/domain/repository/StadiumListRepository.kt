package com.carlosprieto.wordline.domain.repository

import com.carlosprieto.wordline.data.remote.response.StadiumListResponse

interface StadiumListRepository {

    suspend fun getStadiumList(): StadiumListResponse

}
