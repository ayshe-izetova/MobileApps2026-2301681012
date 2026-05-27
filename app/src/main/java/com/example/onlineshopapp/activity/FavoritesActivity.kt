package com.example.onlineshopapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshopapp.databinding.ActivityFavoriteBinding

class FavoritesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
