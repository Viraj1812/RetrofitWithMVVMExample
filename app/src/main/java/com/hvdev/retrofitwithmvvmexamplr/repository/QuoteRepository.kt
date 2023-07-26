package com.hvdev.retrofitwithmvvmexamplr.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hvdev.retrofitwithmvvmexamplr.api.QuoteService
import com.hvdev.retrofitwithmvvmexamplr.models.QuoteList

class QuoteRepository(private val quoteService: QuoteService) {

    private val quoteLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList>
    get() = quoteLiveData

    suspend fun getQuotes(page: Int){
        val result = quoteService.getQuote(page)
        if(result?.body() != null)
        {
            quoteLiveData.postValue(result.body())
        }
    }

}