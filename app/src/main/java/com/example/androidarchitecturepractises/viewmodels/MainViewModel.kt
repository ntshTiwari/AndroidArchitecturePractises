package com.example.androidarchitecturepractises.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecturepractises.models.Product
import com.example.androidarchitecturepractises.repository.ProductRepository
import kotlinx.coroutines.launch

/// as we cannot create a ViewModel with its constructor, so we will create a factory method for this (MainViewModelFactory)
class MainViewModel(private val repository: ProductRepository): ViewModel() {

    val productsLiveData : LiveData<List<Product>>
    get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}