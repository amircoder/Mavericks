package com.multithread.dindinntest.ui.venue

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.VenueEntity

data class VenueState(
    val categories: Async<List<CategoryEntity>> = Uninitialized
): MvRxState