package com.example.onlineshopapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.onlineshopapp.activity.FavoritesActivity
import com.example.onlineshopapp.adapter.CategoryAdapter
import com.example.onlineshopapp.adapter.PopularAdapter
import com.example.onlineshopapp.databinding.ActivityMainBinding
import com.example.onlineshopapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.imageViewFavorite.setOnClickListener {
            startActivity(Intent(this, FavoritesActivity::class.java))
        }

        setContentView(binding.root)

        initBanner()
        initCategory()
        initPopular()

        binding.imageViewFavorite.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initPopular() {
        binding.progressBarPopular.visibility = View.VISIBLE
        viewModel.loadPopular().observeForever {
            binding.recyclerViewPopular.layoutManager =
                GridLayoutManager(
                    this,
                    2,
                )
            binding.recyclerViewPopular.adapter = PopularAdapter(it)
            binding.progressBarPopular.visibility = View.GONE
        }
        viewModel.loadPopular()
    }

    private fun initCategory() {
        binding.progressBarCat.visibility = View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.recyclerViewCat.layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false,
                )
            binding.recyclerViewCat.adapter = CategoryAdapter(it)
            binding.progressBarCat.visibility = View.GONE
        }
        viewModel.loadCategory()
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility = View.VISIBLE

        viewModel.loadBanner().observeForever {
            Glide
                .with(binding.banner.context)
                .load(it[0].url)
                .into(binding.banner)

            binding.progressBarBanner.visibility = View.GONE
        }
        viewModel.loadBanner()
    }
}
