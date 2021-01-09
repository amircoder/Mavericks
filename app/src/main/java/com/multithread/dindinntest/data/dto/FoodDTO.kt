package com.multithread.dindinntest.data.dto


data class FoodDTO(
    val id: String,
    val title: String,
    val description: String = "",
    val info: String = "",
    val price: PriceDTO,
    val imageUrl: String
)