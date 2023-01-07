package com.example.androidarchitecturepractises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// we attach an observer named Observer to this Activity
        lifecycle.addObserver(Observer())

        Log.e("ACTIVITY:", "onCreate called")
    }

    override fun onPause() {
        Log.e("ACTIVITY:", "onPause called")
        super.onPause()
    }

    override fun onDestroy() {
        Log.e("ACTIVITY:", "onDestroy called")
        super.onDestroy()
    }

    override fun onStop() {
        Log.e("ACTIVITY:", "onStop called")
        super.onStop()
    }
}