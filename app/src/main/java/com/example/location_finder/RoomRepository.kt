package com.example.location_finder

import androidx.lifecycle.LiveData

class RoomRepositry(private val wordDao: WordDao) {

    val allDatas: LiveData<List<DataEntity>> = wordDao.getAlphabetizedWords()

    suspend fun insert(data:DataEntity){
        wordDao.insert(data)
    }
}