package com.example.bloom.di

import com.example.bloom.common.Constant.BASE_URL
import com.example.bloom.data.remote.FoodyAPI
import com.example.bloom.data.repository.FoodRepoImpl
import com.example.bloom.domain.repository.FoodRepository
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
    fun provideFoodyApi(): FoodyAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoodyAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: FoodyAPI): FoodRepository {
        return FoodRepoImpl(api)
    }
}