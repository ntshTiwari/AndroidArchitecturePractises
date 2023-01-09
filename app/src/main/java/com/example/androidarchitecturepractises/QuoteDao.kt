package com.example.androidarchitecturepractises

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote")
//    suspend fun getQuotes(): LiveData<List<Quote>>
    fun getQuotes(): LiveData<List<Quote>>
    /// as this function returns a LiveData, so it is automatically a suspend function, making it a coroutine

    @Insert
    suspend fun insertQuote(newQuote: Quote)
    /// as this need to run on the bg thread, so we make it a suspend function, to use it with coroutine
}