package com.example.location_finder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        private val newWordActivityRequestCode = 1
        private val roomViewModel : RoomViewModel by viewModels{
            RoomViewModelFactory((application as RoomApplication).repository)
        }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        }
}