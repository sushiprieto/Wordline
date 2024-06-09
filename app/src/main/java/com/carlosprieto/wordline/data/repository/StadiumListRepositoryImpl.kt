package com.carlosprieto.wordline.data.repository

import com.carlosprieto.wordline.data.remote.response.StadiumItemResponse
import com.carlosprieto.wordline.data.remote.response.StadiumListResponse
import com.carlosprieto.wordline.data.remote.service.StadiumListApi
import com.carlosprieto.wordline.domain.repository.StadiumListRepository
import javax.inject.Inject

class StadiumListRepositoryImpl @Inject constructor(
    private val api: StadiumListApi
) : StadiumListRepository {

    override suspend fun getStadiumList(): StadiumListResponse = api.getStadiumsList()

}
