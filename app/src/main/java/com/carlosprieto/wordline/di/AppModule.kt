package com.carlosprieto.wordline.di

import com.carlosprieto.wordline.common.Constants
import com.carlosprieto.wordline.data.remote.service.StadiumListApi
import com.carlosprieto.wordline.data.repository.StadiumListRepositoryImpl
import com.carlosprieto.wordline.domain.repository.StadiumListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStadiumListApi(): StadiumListApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StadiumListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStadiumListRepository(api: StadiumListApi): StadiumListRepository {
        return StadiumListRepositoryImpl(api)
    }
}
