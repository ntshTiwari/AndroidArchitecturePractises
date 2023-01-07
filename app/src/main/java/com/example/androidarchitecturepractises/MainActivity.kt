package com.example.androidarchitecturepractises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val textView: TextView
    get() = findViewById(R.id.textview)

    private val updateBtn: Button
    get() = findViewById(R.id.updateBtn)

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        updateBtn.setOnClickListener {
            mainViewModel.updateQuote("This is a new quote")
        }

        mainViewModel.quote.observe(this) {
            textView.text = it
        }

    }
}