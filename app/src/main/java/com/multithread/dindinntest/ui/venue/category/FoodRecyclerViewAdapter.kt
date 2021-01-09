package com.multithread.dindinntest.ui.venue.category

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.multithread.dindinntest.AppConstant
import com.multithread.dindinntest.R
import com.multithread.dindinntest.base.BaseViewHolder
import com.multithread.dindinntest.databinding.ItemFoodBinding
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


class FoodItemRecyclerViewHolder(
        private val binding: ItemFoodBinding,
        private val imageLoader: ImageLoader,
        private val callback: (FoodEntity) -> Unit,
        private val handler: CategoryFragment.MemoryLeakProofHandler
) : BaseViewHolder<FoodEntity>(binding.root) {

    companion object {
        fun create(parent: ViewGroup,
                   callback: (FoodEntity) -> Unit,
                   imageLoader: ImageLoader,
                   handler: CategoryFragment.MemoryLeakProofHandler

        ) = FoodItemRecyclerViewHolder(
                ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                imageLoader,
                callback,
                handler)
    }

    override fun bind(food: FoodEntity) {
        binding.itemFoodAddButton.text = getString(R.string.price_format).format(food.price.total, food.price.unit)
        imageLoader.loadImage(
                binding.itemFoodImageView, 0, 0,
                food.imageUrl
        )

        binding.itemFoodAddButton.setOnClickListener {
            changeToUIAddStated()
            prepareSetBackToNormalUIState(food)
        }
    }

    private fun prepareSetBackToNormalUIState(food: FoodEntity) {
        handler.postDelayed({
            kotlin.runCatching {
                binding.itemFoodAddButton.setBackgroundResource(R.drawable.background_button_default)
                binding.itemFoodAddButton.text = getString(R.string.price_format).format(food.price.total, food.price.unit)
            }.getOrElse {
                it.printStackTrace()
            }
        }, AppConstant.Timing.ANIMATION_DEFAULT_DURATION)

    }

    private fun changeToUIAddStated() {
        binding.itemFoodAddButton.setBackgroundResource(R.drawable.background_button_touch)
        binding.itemFoodAddButton.setText(R.string.added_plus_one)
    }

}