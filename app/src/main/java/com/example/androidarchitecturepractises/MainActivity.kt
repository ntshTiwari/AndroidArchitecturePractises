package com.example.androidarchitecturepractises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidarchitecturepractises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /// in order to access higher quality, very large files, glide fails
        val post = Post("Post title", "Post description", "https://goo.gl/gEgYUd")

        activityMainBinding.post = post
    }
}