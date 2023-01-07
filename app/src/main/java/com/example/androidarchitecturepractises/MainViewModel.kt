package com.example.androidarchitecturepractises

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    /// MutableLiveData is editable, so we keep it private
    /// But LiveData is readonly, so we expose it with a getter function pointing to the mutable original data

    /// We generally follow this pattern, the actual data is the MutableLiveData, and what others access
    /// is the LiveData version of the MutableLiveData
    private val quoteObject = MutableLiveData<String>("Random quote")

    val quote: LiveData<String>
    get() = quoteObject

    fun updateQuote(newQuote: String) {
        quoteObject.value = newQuote
    }

    /// for an array type data
    private val quoteObjectArray = MutableLiveData<ArrayList<String>>()
    val quoteArray: LiveData<ArrayList<String>>
        get() = quoteObjectArray
    fun updateQuoteArray(newQuote: String) {
        quoteObjectArray.value?.add(newQuote)
    }
}