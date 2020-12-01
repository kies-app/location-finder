package com.example.location_finder

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class RoomRepository(private val wordDao: WordDao) {

    val allDatas: Flow<List<DataEntity>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word:DataEntity){
        wordDao.insert(word)
    }
}