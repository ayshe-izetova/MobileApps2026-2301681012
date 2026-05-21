package com.example.onlineshopapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopapp.R
import com.example.onlineshopapp.databinding.ViewholderCategoryBinding
import com.example.onlineshopapp.domain.CategoryModel

class CategoryAdapter(
    private val items: List<CategoryModel>,
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private lateinit var context: Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    class ViewHolder(
        val binding: ViewholderCategoryBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        context = parent.context
        val binding =
            ViewholderCategoryBinding.inflate(
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
        holder.binding.titleCatTxt.text = item.title

        holder.binding.root.setOnClickListener {
            val currentPosition = holder.adapterPosition
            if (currentPosition == RecyclerView.NO_POSITION) return@setOnClickListener

            lastSelectedPosition = selectedPosition
            selectedPosition = currentPosition

            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }

        if (selectedPosition == position) {
            holder.binding.titleCatTxt.setBackgroundResource(R.drawable.orange_bg)
            holder.binding.titleCatTxt.setTextColor(ContextCompat.getColor(context, R.color.white))
        } else {
            holder.binding.titleCatTxt.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.titleCatTxt.setTextColor(ContextCompat.getColor(context, R.color.black))
        }
    }

    override fun getItemCount(): Int = items.size
}
