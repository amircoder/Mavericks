package com.multithread.dindinntest.data.dto


import com.google.gson.annotations.SerializedName

data class NameDTO(
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)