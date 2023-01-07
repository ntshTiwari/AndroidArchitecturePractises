package com.example.androidarchitecturepractises.retrofit

import com.example.androidarchitecturepractises.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}