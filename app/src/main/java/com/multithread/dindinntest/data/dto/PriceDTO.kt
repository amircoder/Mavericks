package com.multithread.dindinntest.data.dto

import com.multithread.dindinntest.AppConstant

data class PriceDTO(
    val total: Double,
    val unit: String = AppConstant.DEFAULT_UNIT
)