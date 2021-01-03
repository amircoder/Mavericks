package com.multithread.dindinntest.ui.venue.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multithread.dindinntest.R
import com.multithread.dindinntest.base.BaseViewHolder
import com.multithread.dindinntest.domain.entity.FoodEntity

class FoodRecyclerViewAdapter(
    private val items: List<FoodEntity>,
    private val callback: (FoodEntity) -> Unit
) :
    RecyclerView.Adapter<FoodItemRecyclerViewHolder>() {

    var itemList: List<FoodEntity> = items
        set(value) {
            field = value
            if (field.isNotEmpty())
                notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemRecyclerViewHolder =
        FoodItemRecyclerViewHolder.create(parent, callback)

    override fun onBindViewHolder(holder: FoodItemRecyclerViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}


class FoodItemRecyclerViewHolder(
    private val view: View,
    private val callback: (FoodEntity) -> Unit
) : BaseViewHolder<FoodEntity>(view) {

    companion object {
        fun create(parent: ViewGroup, callback: (FoodEntity) -> Unit) = FoodItemRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false),
            callback
        )
    }

    override fun bind(t: FoodEntity) {

    }

}