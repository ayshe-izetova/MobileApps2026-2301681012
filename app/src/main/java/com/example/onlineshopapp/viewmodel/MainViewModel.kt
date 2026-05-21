package com.example.onlineshopapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshopapp.domain.BannerModel
import com.example.onlineshopapp.domain.CategoryModel
import com.example.onlineshopapp.repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<List<BannerModel>> = repository.loadBanner()

    fun loadCategory(): LiveData<List<CategoryModel>> = repository.loadCategory()
}
