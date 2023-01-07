package com.example.androidarchitecturepractises

import androidx.lifecycle.ViewModel

/// this is a viewmodel specific to MainActivity activity,
/// it will store all the data needed for MainActivity activity
/// this is just like a model class
class MainViewModel: ViewModel() {
    var count: Int = 0;

    fun increment() {
        count++;
    }
}