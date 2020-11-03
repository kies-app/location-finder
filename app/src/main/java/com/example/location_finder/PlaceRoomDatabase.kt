package com.example.location_finder

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [DataEntity::class], version = 1, exportSchema = false)
public abstract class PlaceRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PlaceRoomDatabase? = null

        fun getDatabase(context: Context): PlaceRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlaceRoomDatabase::class.java,
                    "Place_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}