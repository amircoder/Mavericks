package com.multithread.dindinntest.util

import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.VenueEntity
import java.util.*

object DataHelper {
    fun createVenueEntity() = VenueEntity(
        id = UUID.randomUUID().toString(),
        name = "Kazarov Delivery",
        coverImages = listOf("https://homepages.cae.wisc.edu/~ece533/images/fruits.png",
        "https://homepages.cae.wisc.edu/~ece533/images/frymire.png",
        "https://homepages.cae.wisc.edu/~ece533/images/serrano.png"
        ),
        categories = createCategoryList(),
        logoUrl = "https://homepages.cae.wisc.edu/~ece533/images/watch.png"
    )

    private fun createCategoryList(): List<CategoryEntity> = mutableListOf()
}