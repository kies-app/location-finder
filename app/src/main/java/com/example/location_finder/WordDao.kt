package com.example.location_finder

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM DataEntity")
    fun getAlphabetizedWords(): LiveData<List<DataEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: DataEntity)

    @Query("DELETE FROM DataEntity")
    suspend fun deleteAll()
}