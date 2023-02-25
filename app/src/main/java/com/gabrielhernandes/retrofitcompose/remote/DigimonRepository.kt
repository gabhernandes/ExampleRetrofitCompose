package com.gabrielhernandes.retrofitcompose.remote

import android.util.Log
import com.gabrielhernandes.retrofitcompose.response.DigimonList
import com.gabrielhernandes.retrofitcompose.service.DigimonApi
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DigimonRepository @Inject constructor(private val digimonApi: DigimonApi) {
    suspend fun getDigimonList(): DigimonList {
        try {
            return digimonApi.getDigimonList()
        } catch (e: Exception) {
            Log.d("ERROR", e.message.toString())
        }
        return DigimonList()
    }
}