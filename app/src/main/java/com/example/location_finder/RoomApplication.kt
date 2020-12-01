package com.example.location_finder

import android.app.Application
import androidx.room.RoomDatabase

class RoomApplication:Application() {
    val database by lazy { PlaceRoomDatabase.getDatabase(this)}
    val repository by lazy {RoomRepository(database.wordDao())}
}