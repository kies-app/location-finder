package com.example.location_finder

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity
data class DataEntity(@PrimaryKey val title:String,
                      val text:String,
                      
                      val picture:Blob)