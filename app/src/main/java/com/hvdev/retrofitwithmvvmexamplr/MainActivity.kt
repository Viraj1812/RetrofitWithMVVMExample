package com.hvdev.retrofitwithmvvmexamplr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.hvdev.retrofitwithmvvmexamplr.api.QuoteService
import com.hvdev.retrofitwithmvvmexamplr.api.RetrofitHelper
import com.hvdev.retrofitwithmvvmexamplr.repository.QuoteRepository
import com.hvdev.retrofitwithmvvmexamplr.viewmodels.MainViewModel
import com.hvdev.retrofitwithmvvmexamplr.viewmodels.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this,{
            Log.d("Test", it.results.toString())
        })
    }
}