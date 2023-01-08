package com.example.androidarchitecturepractises

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val quote = MutableLiveData<Quote>(Quote("This is a random quote", "An Author"))

    fun updateQuote(newQuoteQuote: String, newQuoteAuthor: String, ){
        quote.value = Quote(newQuoteQuote, newQuoteAuthor)
    }
}