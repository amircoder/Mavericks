package com.multithread.dindinntest.ui.venue.category

import android.view.LayoutInflater
import android.view.ViewGroup
import com.multithread.dindinntest.AppConstant
import com.multithread.dindinntest.R
import com.multithread.dindinntest.base.BaseViewHolder
import com.multithread.dindinntest.databinding.ItemFoodBinding
import com.multithread.dindinntest.domain.entity.FoodEntity
import com.multithread.dindinntest.util.ImageLoader


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
        bindTexts(food)
        loadImage(food)
        initListeners(food)
    }

    private fun initListeners(food: FoodEntity) {
        binding.itemFoodAddButton.setOnClickListener {
            changeToUIAddState()
            prepareSetBackToNormalUIState(food)
            callback(food)
        }
    }

    private fun loadImage(food: FoodEntity) {
        imageLoader.loadImage(
                binding.itemFoodImageView, 0, 0,
                food.imageUrl
        )
    }

    private fun bindTexts(food: FoodEntity) {
        binding.itemFoodTitleTextView.text = food.title
        binding.itemFoodAddButton.text = getString(R.string.price_format).format(food.price.total, food.price.unit)
        binding.itemFoodDescriptionTextView.text = food.description
        binding.itemFoodInfoTextView.text = food.info
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

    private fun changeToUIAddState() {
        binding.itemFoodAddButton.setBackgroundResource(R.drawable.background_button_touch)
        binding.itemFoodAddButton.setText(R.string.added_plus_one)
    }

}