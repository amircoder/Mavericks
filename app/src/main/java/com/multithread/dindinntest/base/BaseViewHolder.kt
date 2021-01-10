package com.multithread.dindinntest.base

import android.view.View
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(t: T)
    protected fun getString(@StringRes id: Int) = itemView.context.getString(id)
}