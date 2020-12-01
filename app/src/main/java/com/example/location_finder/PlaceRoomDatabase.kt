package com.example.location_finder

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [DataEntity::class], version = 1, exportSchema = false)
public abstract class PlaceRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    private class PlaceDataBaseCallback(
        private val scope: CoroutineScope
    ):RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    val wordDao = database.wordDao()

                    wordDao.deleteAll()

                    val data1 = DataEntity("kotlin","aaaaaaa",R.drawable.ic_launcher_background)
                    wordDao.insert(data1)
                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PlaceRoomDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope
        ): PlaceRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlaceRoomDatabase::class.java,
                    "Place_database"
                )
                    .addCallback(PlaceDataBaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}