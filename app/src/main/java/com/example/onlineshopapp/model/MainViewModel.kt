package com.example.onlineshopapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshopapp.domain.BannerModel
import com.example.onlineshopapp.repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<List<BannerModel>> = repository.loadBanner()
}
