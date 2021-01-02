package com.multithread.dindinntest.data.dto

import com.multithread.dindinntest.domain.entity.PriceEntity

data class FoodDTO(
    val id: String,
    val title: String,
    val price: PriceDTO,
    val imageUrl: String
)