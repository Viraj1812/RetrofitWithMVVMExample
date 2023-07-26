package com.hvdev.retrofitwithmvvmexamplr.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hvdev.retrofitwithmvvmexamplr.repository.QuoteRepository

class MainViewModelFactory(private val repository: QuoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}