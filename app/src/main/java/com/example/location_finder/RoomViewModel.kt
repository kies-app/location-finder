package com.example.location_finder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : RoomRepository

    val allDatas:LiveData<List<DataEntity>>

    init {
        val datasDao = PlaceRoomDatabase.getDatabase(application,viewModelScope).wordDao()
        repository = RoomRepository(datasDao)
        allDatas = repository.allDatas
    }

    fun insert(data:DataEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(data)
    }
}