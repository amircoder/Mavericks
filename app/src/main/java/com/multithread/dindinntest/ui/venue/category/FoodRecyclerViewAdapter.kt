package com.multithread.dindinntest.ui.venue.category

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multithread.dindinntest.domain.entity.FoodEntity
import com.multithread.dindinntest.util.ImageLoader


class FoodRecyclerViewAdapter(
        private val imageLoader: ImageLoader,
        private val callback: (FoodEntity) -> Unit,
        private val handler: CategoryFragment.MemoryLeakProofHandler
) : RecyclerView.Adapter<FoodItemRecyclerViewHolder>() {

    var foodItems: List<FoodEntity> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemRecyclerViewHolder {
        return FoodItemRecyclerViewHolder.create(parent, callback, imageLoader, handler)
    }

    override fun onBindViewHolder(holder: FoodItemRecyclerViewHolder, position: Int) {
        holder.bind(foodItems[position])
    }

    override fun getItemCount(): Int {
        return foodItems.size
    }
}