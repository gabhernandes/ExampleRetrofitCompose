package com.gabrielhernandes.retrofitcompose.service

import com.gabrielhernandes.retrofitcompose.response.DigimonList
import com.gabrielhernandes.retrofitcompose.response.DigimonListItem
import retrofit2.http.GET

interface DigimonApi {
    @GET("digimon")
    suspend fun getDigimonList() : DigimonList
}