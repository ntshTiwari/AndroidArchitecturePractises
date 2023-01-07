package com.example.androidarchitecturepractises.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturepractises.repository.ProductRepository
import javax.inject.Inject

/// as Dagger can provide us this repository object, so we get it from Dagger using Inject
/// this is the factory class that will create the MainViewModel class
class MainViewModelFactory @Inject constructor(private val repository: ProductRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}