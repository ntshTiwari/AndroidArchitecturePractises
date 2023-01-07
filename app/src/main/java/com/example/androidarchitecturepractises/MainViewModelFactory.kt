package com.example.androidarchitecturepractises

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/// as our ViewModel (MainViewModel), now needs a parameter to be constructed,
/// so we use a factory class here to create the instance of ViewModel (MainViewModel) with the parameter
class MainViewModelFactory(private val counter: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(counter) as T
    }
}