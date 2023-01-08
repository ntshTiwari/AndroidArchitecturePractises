package com.example.androidarchitecturepractises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidarchitecturepractises.databinding.ActivityMainBinding

/// NOTE: We can't use dataBinding and viewBinding together
///
/// We can't use them togheter in the same layout.
/// ViewBinding is a subset of what DataBinding can do and should be used if you want to replace libraries like
/// ButterKnife, KotterKnife or KAE (Kotlin Android Extensions) but don't want to invest in databinding refactoring.
class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /// we pass the data to be used in the view
        activityMainBinding.quote = Quote("This is a random quote", "An Author")
    }
}