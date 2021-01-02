package com.multithread.dindinntest.domain.entity

import com.multithread.dindinntest.AppConstant

data class PriceEntity(
    val total: Double,
    val unit: String = AppConstant.DEFAULT_UNIT
)