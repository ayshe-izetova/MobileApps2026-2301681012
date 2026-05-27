package com.example.onlineshopapp.repository

import android.content.Context
import com.example.onlineshopapp.data.local.DatabaseProvider
import com.example.onlineshopapp.data.local.FavoriteEntity

class FavoriteRepository(
    context: Context,
) {
    private val favoriteDao =
        DatabaseProvider.getDatabase(context).favoriteDao()

    suspend fun insertFavorite(favorite: FavoriteEntity) {
        favoriteDao.insertFavorite(favorite)
    }

    suspend fun getAllFavorites(): List<FavoriteEntity> = favoriteDao.getAllFavorites()

    suspend fun updateFavorite(favorite: FavoriteEntity) {
        favoriteDao.updateFavorite(favorite)
    }

    suspend fun deleteFavorite(favorite: FavoriteEntity) {
        favoriteDao.deleteFavorite(favorite)
    }
}
