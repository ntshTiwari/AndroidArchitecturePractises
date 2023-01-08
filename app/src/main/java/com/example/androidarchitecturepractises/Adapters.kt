package com.example.androidarchitecturepractises

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/// here we are setting a BindingAdapter for View = ImageView named imageFromUrl
/// it means that, when now we set the property imageFromUrl in ImageView, then this function will be called
/// kind of a custom function

@BindingAdapter("imageFromUrl")
fun ImageView.imageFromUrl(url: String){
    Log.e("ImageView:", "imageFromUrl BindingAdapter called with $url")
    Glide.with(this.context).load(url).into(this)
}