package com.gabrielhernandes.retrofitcompose.list

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielhernandes.retrofitcompose.remote.DigimonRepository
import com.gabrielhernandes.retrofitcompose.response.DigimonListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: DigimonRepository) : ViewModel() {
    var list = mutableStateOf<List<DigimonListItem>>(listOf())

    init {
        loadDigimons()
    }

    private fun loadDigimons() {
        viewModelScope.launch {
            list.value = repository.getDigimonList()
        }
    }
}