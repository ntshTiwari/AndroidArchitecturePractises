package com.example.androidarchitecturepractises

import androidx.lifecycle.LiveData

class QuoteRepository(private val quoteDao: QuoteDao) {
    fun getQuotes() : LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(newQuote: Quote) {
        quoteDao.insertQuote(newQuote)
    }
}