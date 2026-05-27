package com.example.onlineshopapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshopapp.activity.DetailActivity
import com.example.onlineshopapp.databinding.ViewholderPopularBinding
import com.example.onlineshopapp.domain.ItemsModel

class PopularAdapter(
    val items: List<ItemsModel>,
) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    lateinit var context: Context

    class ViewHolder(
        val binding: ViewholderPopularBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PopularAdapter.ViewHolder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PopularAdapter.ViewHolder,
        position: Int,
    ) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceTxt.text = "$" + items[position].price.toString()

        Glide
            .with(context)
            .load(items[position].thumbnail)
            .into(holder.binding.pic)

        holder.binding.root.setOnClickListener {
            val currentPosition = holder.adapterPosition
            if (currentPosition == RecyclerView.NO_POSITION) return@setOnClickListener

            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("object", items[currentPosition])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}
