package com.example.androidarchitecturepractises.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidarchitecturepractises.models.Product
import com.example.androidarchitecturepractises.retrofit.FakerApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerApi: FakerApi) {

    /// as it is mutable so we make it private, so it cannot be changed from outside
    private val _products = MutableLiveData<List<Product>>()

    /// as it is a LiveData, so it can be changed from outside, that is why it only has a get method and no set() method
    /// LiveData is readonly
    val products: LiveData<List<Product>>
    get() = _products
    /// get() is used to define a custom getter method. Anytime you access the property you are using the custom getter method

    suspend fun getProducts() {
        val result = fakerApi.getProducts()
        if(result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        }
    }

}