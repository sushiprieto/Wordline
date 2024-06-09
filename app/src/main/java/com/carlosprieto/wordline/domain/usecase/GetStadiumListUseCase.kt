package com.carlosprieto.wordline.domain.usecase

import com.carlosprieto.wordline.common.Resource
import com.carlosprieto.wordline.data.remote.response.StadiumListResponse
import com.carlosprieto.wordline.domain.repository.StadiumListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStadiumListUseCase @Inject constructor(
    private val repository: StadiumListRepository
) {
    operator fun invoke(): Flow<Resource<StadiumListResponse>> = flow {
        try {
            emit(Resource.Loading())
            val stadiums = repository.getStadiumList()
            emit(Resource.Success(stadiums))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
