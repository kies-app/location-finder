package com.example.location_finder

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.location_finder.DataEntity as DataEntity1

@Dao
interface WordDao {

    @Query("SELECT * FROM DataEntity")
    fun getAlphabetizedWords(): kotlinx.coroutines.flow.Flow<List<DataEntity1>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: DataEntity1)

    @Query("DELETE FROM DataEntity")
    suspend fun deleteAll()
}