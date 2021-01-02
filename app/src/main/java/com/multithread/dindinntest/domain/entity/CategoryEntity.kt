package com.multithread.dindinntest.domain.entity

data class CategoryEntity(
    val id: String,
    val name: String,
    val products: List<FoodEntity>
)