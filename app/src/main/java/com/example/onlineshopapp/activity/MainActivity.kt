package com.example.onlineshopapp.activity

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.onlineshopapp.adapter.CategoryAdapter
import com.example.onlineshopapp.databinding.ActivityMainBinding
import com.example.onlineshopapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initBanner()
        initCategory()
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
