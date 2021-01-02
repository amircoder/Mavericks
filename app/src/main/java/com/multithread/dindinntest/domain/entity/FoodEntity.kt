package com.multithread.dindinntest.domain.entity

data class FoodEntity(
    val id: String,
    val title: String,
    val price: PriceEntity,
    val imageUrl: String
)