package com.example.location_finder

import androidx.lifecycle.LiveData

class RoomRepository(private val wordDao: WordDao) {

    val allDatas: LiveData<List<DataEntity>> = wordDao.getAlphabetizedWords()

    suspend fun insert(data:DataEntity){
        wordDao.insert(data)
    }
}