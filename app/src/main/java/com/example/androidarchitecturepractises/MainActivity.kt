package com.example.androidarchitecturepractises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var button: Button

    lateinit var mainViewModel: MainViewModel

    val initialCounterValue = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// we pass the context to the ViewModelProvider and create an instance of the MainViewModel class
        /// this will help MainViewModel to have one instance till this activity is destroyed

        /// in order to create an instance of the ViewModel that needs a parameter we will pass
        /// our factory method to the ViewModelProvider and pass the parameter to the factory class
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(initialCounterValue))
            .get(MainViewModel::class.java)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.increment)

        button.setOnClickListener { increment() }

        setText()
    }

    fun setText() {
        textView.text = mainViewModel.count.toString()
    }

    fun increment() {
        mainViewModel.increment()
        setText()
    }
}