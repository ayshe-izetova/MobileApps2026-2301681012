package com.example.onlineshopapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshopapp.data.local.FavoriteEntity
import com.example.onlineshopapp.databinding.ViewholderFavoriteBinding

class FavoritesAdapter(
    private val items: List<FavoriteEntity>,
    private val onDeleteClick: (FavoriteEntity) -> Unit,
    private val onUpdateClick: (FavoriteEntity) -> Unit,
) : RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {
    class ViewHolder(
        val binding: ViewholderFavoriteBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding =
            ViewholderFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        val item = items[position]

        holder.binding.favoriteTitleTxt.text = item.title
        holder.binding.favoritePriceTxt.text = "$${item.price}"
        holder.binding.deleteFavoriteBtn.setOnClickListener {
            onDeleteClick(item)
        }
        holder.binding.updateFavoriteBtn.setOnClickListener {
            onUpdateClick(item)
        }

        Glide
            .with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.binding.favoriteImg)
    }

    override fun getItemCount(): Int = items.size
}
