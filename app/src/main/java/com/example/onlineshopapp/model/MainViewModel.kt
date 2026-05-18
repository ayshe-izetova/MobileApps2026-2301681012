package com.example.onlineshopapp.model

import androidx.lifecycle.ViewModel
import com.example.onlineshopapp.repository.MainRepository
import androidx.lifecycle.LiveData
import com.example.onlineshopapp.domain.BannerModel

class MainViewModel:ViewModel() {
    private val repository=MainRepository()

    fun loadBanner():LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }
}