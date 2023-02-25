package com.gabrielhernandes.retrofitcompose.utils

import android.app.Application
import com.gabrielhernandes.retrofitcompose.remote.DigimonRepository
import com.gabrielhernandes.retrofitcompose.service.DigimonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@HiltAndroidApp
class DigimonApp : Application()

@Module
@InstallIn(SingletonComponent::class)
object DigimonModule {

    @Singleton
    @Provides
    fun provideDigimonRepository(api: DigimonApi) = DigimonRepository(api)

    @Singleton
    @Provides
    fun provideDigimonApi(): DigimonApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://digimon-api.vercel.app/api/")
            .build()
            .create(DigimonApi::class.java)
}