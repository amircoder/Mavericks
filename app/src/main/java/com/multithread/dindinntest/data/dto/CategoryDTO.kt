package com.multithread.dindinntest.data.dto


data class CategoryDTO(
    val id: String,
    val name: String,
    val products: List<FoodDTO>
)