package com.example.androidarchitecturepractises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturepractises.repository.ProductRepository
import com.example.androidarchitecturepractises.retrofit.FakerApi
import com.example.androidarchitecturepractises.utils.Constants
import com.example.androidarchitecturepractises.viewmodels.MainViewModel
import com.example.androidarchitecturepractises.viewmodels.MainViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val products: TextView
    get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// this will inject all our fields using Dagger
        (application as FakerApplication).applicationComponent.inject(this)

        /// if we don't use Dagger, then we might have to pass all objects like this
//        mainViewModelFactory = MainViewModelFactory(ProductRepository(
//            Retrofit.Builder().baseUrl(Constants.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build().create(FakerApi::class.java)
//        ))

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this, {
           products.text =  it.joinToString { x -> x.title + "\n\n" }
        })
    }
}