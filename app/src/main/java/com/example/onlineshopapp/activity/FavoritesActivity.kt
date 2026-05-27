package com.example.onlineshopapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshopapp.adapter.FavoritesAdapter
import com.example.onlineshopapp.data.local.FavoritesDbHelper
import com.example.onlineshopapp.databinding.ActivityFavoriteBinding

class FavoritesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var dbHelper: FavoritesDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = FavoritesDbHelper(this)

        binding.recyclerViewFavorites.layoutManager =
            LinearLayoutManager(this)

        loadFavorites()
    }

    private fun loadFavorites() {
        val favorites = dbHelper.getAllFavorites()

        binding.recyclerViewFavorites.adapter =
            FavoritesAdapter(
                favorites,
                onDeleteClick = { favorite ->
                    dbHelper.deleteFavorite(favorite.id)
                    loadFavorites()
                },
                onUpdateClick = { favorite ->
                    dbHelper.updateFavoritePrice(
                        favorite.id,
                        favorite.price + 1,
                    )
                    loadFavorites()
                },
            )
    }
}
