package com.example.onlineshopapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshopapp.R
import com.example.onlineshopapp.databinding.ViewholderPicBinding

class PicsAdapter(
    val items: List<String>,
    val onImageSelected: (String) -> Unit,
) : RecyclerView.Adapter<PicsAdapter.ViewHolder>() {
    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    class ViewHolder(
        val binding: ViewholderPicBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PicsAdapter.ViewHolder {
        val binding = ViewholderPicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PicsAdapter.ViewHolder,
        position: Int,
    ) {
        val item = items[position]

        holder.binding.pic.loadImage(item)

        holder.binding.root.setOnClickListener {
            val currentPosition = holder.adapterPosition
            if (currentPosition == RecyclerView.NO_POSITION) return@setOnClickListener

            lastSelectedPosition = selectedPosition
            selectedPosition = currentPosition

            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            onImageSelected(items[currentPosition])
        }

        if (selectedPosition == position) {
            holder.binding.picLayout.setBackgroundResource(R.drawable.orange_stroke_bg)
        } else {
            holder.binding.picLayout.setBackgroundResource(R.drawable.grey_stroke_bg)
        }
    }

    override fun getItemCount(): Int = items.size

    fun ImageView.loadImage(url: String) {
        Glide
            .with(this.context)
            .load(url)
            .into(this)
    }
}
