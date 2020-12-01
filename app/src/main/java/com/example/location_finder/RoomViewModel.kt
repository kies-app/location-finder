package com.example.location_finder


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class RoomViewModel(private val repository: RoomRepository) : ViewModel() {

    val allDatas: Flow<List<DataEntity>> = repository.allDatas

    fun insert(data:DataEntity) = viewModelScope.launch{
        repository.insert(data)
    }
}

class RoomViewModelFactory(private val repository: RoomRepository):ViewModelProvider.Factory{
    override fun<T:ViewModel> create(modelClass:Class<T>):T{
        if (modelClass.isAssignableFrom(RoomViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return RoomViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}