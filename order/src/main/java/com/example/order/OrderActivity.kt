package com.example.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        Log.e("OrderActivity","onCreate ")
    }
}