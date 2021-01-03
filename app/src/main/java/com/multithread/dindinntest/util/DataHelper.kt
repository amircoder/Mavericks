package com.multithread.dindinntest.util

import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.VenueEntity
import java.util.*

object DataHelper {
    fun createVenueEntity() = VenueEntity(
        id = UUID.randomUUID().toString(),
        name = "Kazarov Delivery",
        coverImages = listOf("https://images.unsplash.com/photo-1576669801343-117bb4054118?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1886&q=80",
        "https://images.unsplash.com/photo-1578496781329-41da6c97ffc4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
        "https://images.unsplash.com/photo-1576086085526-0de1930a57c7?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80"
        ),
        categories = createCategoryList(),
        logoUrl = "https://images.unsplash.com/photo-1497034825429-c343d7c6a68f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
    )

    private fun createCategoryList(): List<CategoryEntity> = mutableListOf()
}