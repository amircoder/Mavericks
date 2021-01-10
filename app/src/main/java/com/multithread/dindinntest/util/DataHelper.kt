package com.multithread.dindinntest.util

import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.FoodEntity
import com.multithread.dindinntest.domain.entity.PriceEntity
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
            logoUrl  = "https://homepages.cae.wisc.edu/~ece533/images/watch.png"
    )

    private fun createCategoryList(): List<CategoryEntity> = mutableListOf<CategoryEntity>().apply {
        add(
                CategoryEntity(
                        id = UUID.randomUUID().toString(),
                        name = "Pizza",
                        products = createProductList()
                )
        )
        add(
                CategoryEntity(
                        id = UUID.randomUUID().toString(),
                        name = "Drinks",
                        products = createProductList()
                )
        )
    }

    private fun createProductList(): List<FoodEntity> = mutableListOf<FoodEntity>().apply {
        repeat(10) {
            add(
                    FoodEntity(
                            id = UUID.randomUUID().toString(),
                            title = "chicken",
                            description = """Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
|sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
|Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris 
|nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in 
|reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
| Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
|  officia deserunt mollit anim id est laborum.""".trimMargin(),
                            info = "200 gm, 40 cm",
                            price = PriceEntity(300.0),
                            imageUrl = "https://homepages.cae.wisc.edu/~ece533/images/serrano.png"
                    )
            )
        }
    }
}