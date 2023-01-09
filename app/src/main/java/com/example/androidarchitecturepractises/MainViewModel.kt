package com.example.androidarchitecturepractises

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() : LiveData<List<Quote>>{
        return quoteRepository.getQuotes()
    }

    fun insertQuotes(newQuote: Quote){
        /// as insertQuote is a suspend function, so we launch it in a coroutine
        /// viewModelScope coroutine is best for viewModels, and as it is an insert operation, we use Dispatchers.IO
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.insertQuote(newQuote)
        }
    }
}