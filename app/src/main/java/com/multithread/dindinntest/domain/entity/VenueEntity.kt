package com.multithread.dindinntest.domain.entity

data class VenueEntity(
    val id: String,
    val name: String,
    val coverImages: List<String>,
    val categories: List<CategoryEntity>,
    val logoUrl: String
)