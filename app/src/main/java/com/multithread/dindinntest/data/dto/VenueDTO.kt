package com.multithread.dindinntest.data.dto

data class VenueDTO(
    val id: String,
    val name: String,
    val coverImages: List<String>,
    val categories: List<CategoryDTO>,
    val logoUrl: String
)