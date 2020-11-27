package com.example.location_finder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val data = arrayOf("test1","test2","test3","test4","test5")

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                data
            )

           // test_list.adapter = adapter




    }
}