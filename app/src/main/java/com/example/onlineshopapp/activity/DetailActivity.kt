package com.example.onlineshopapp.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.onlineshopapp.adapter.PicsAdapter
import com.example.onlineshopapp.data.local.FavoriteEntity
import com.example.onlineshopapp.data.local.FavoritesDbHelper
import com.example.onlineshopapp.databinding.ActivityDetailBinding
import com.example.onlineshopapp.domain.ItemsModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        item = intent.getSerializableExtra("object") as ItemsModel

        binding.titleTxt.text = item.title
        binding.descriptionTxt.text = item.description
        binding.priceTxt.text = "$${item.price}"
        binding.ratingTxt.text = item.rating.toString()

        initList()
        loadMainImage()
        setupButtons()
    }

    private fun setupButtons() {
        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.favBtn.setOnClickListener {
            val dbHelper = FavoritesDbHelper(this)

            val favorite =
                FavoriteEntity(
                    id = item.title.hashCode(),
                    title = item.title,
                    price = item.price,
                    imageUrl = item.picUrl.firstOrNull() ?: item.thumbnail,
                )

            dbHelper.insertFavorite(favorite)

            Toast
                .makeText(
                    this,
                    "Added to favorites",
                    Toast.LENGTH_SHORT,
                ).show()
        }
    }

    private fun loadMainImage() {
        Glide
            .with(this)
            .load(item.picUrl.firstOrNull() ?: item.thumbnail)
            .into(binding.img)
    }

    private fun initList() {
        val picList = ArrayList<String>()

        for (imageUrl in item.picUrl) {
            picList.add(imageUrl)
        }

        binding.picList.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false,
            )

        binding.picList.adapter =
            PicsAdapter(picList) { selectedImageUrl ->
                Glide
                    .with(this)
                    .load(selectedImageUrl)
                    .into(binding.img)
            }
    }
}
