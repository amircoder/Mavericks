package com.multithread.dindinntest.ui.venue.category

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multithread.dindinntest.R
import com.multithread.dindinntest.base.BaseViewHolder
import com.multithread.dindinntest.databinding.ItemFoodBinding
import com.multithread.dindinntest.domain.entity.FoodEntity
import com.multithread.dindinntest.util.ImageLoader

class FoodRecyclerViewAdapter(
        private val imageLoader: ImageLoader,
        private val callback: (FoodEntity) -> Unit
) : RecyclerView.Adapter<FoodItemRecyclerViewHolder>() {

    var foodItems: List<FoodEntity> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemRecyclerViewHolder {
        return FoodItemRecyclerViewHolder.create(parent, callback, imageLoader)
    }

    override fun onBindViewHolder(holder: FoodItemRecyclerViewHolder, position: Int) {
        holder.bind(foodItems[position])
    }

    override fun getItemCount(): Int {
        return foodItems.size
    }
}


class FoodItemRecyclerViewHolder(
        private val binding: ItemFoodBinding,
        private val imageLoader: ImageLoader,
        private val callback: (FoodEntity) -> Unit
) : BaseViewHolder<FoodEntity>(binding.root) {

    companion object {
        fun create(parent: ViewGroup,
                   callback: (FoodEntity) -> Unit,
                   imageLoader: ImageLoader) = FoodItemRecyclerViewHolder(
                ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                imageLoader,
                callback)
    }

    override fun bind(food: FoodEntity) {
        Log.d("testTag", "bind: name: ${food.title}")
        imageLoader.loadImage(
                binding.itemFoodImageView, 0, 0,
                food.imageUrl
        )

    }

}