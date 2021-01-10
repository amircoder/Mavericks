package com.multithread.dindinntest.data.dto


import com.google.gson.annotations.SerializedName

data class DeliveryDTO(
        @SerializedName("categories")
        val categories: List<CategoryDTO>,
        @SerializedName("coverImages")
        val coverImages: List<String>,
        @SerializedName("id")
        val id: String,
        @SerializedName("logoUrl")
        val logoUrl: String,
        @SerializedName("name")
        val name: NameDTO
)