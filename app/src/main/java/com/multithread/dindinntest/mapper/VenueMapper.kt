package com.multithread.dindinntest.mapper

import android.util.Log
import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.data.dto.CategoryDTO
import com.multithread.dindinntest.data.dto.DeliveryDTO
import com.multithread.dindinntest.data.dto.PriceDTO
import com.multithread.dindinntest.data.dto.ProductDTO
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.FoodEntity
import com.multithread.dindinntest.domain.entity.PriceEntity
import com.multithread.dindinntest.domain.entity.VenueEntity
import javax.inject.Inject

class VenueMapper @Inject constructor() : OneWayMapper<DeliveryDTO, VenueEntity> {
    override fun map(input: DeliveryDTO): VenueEntity {
        Log.d("crashTag", "map: input list: $input")
        return VenueEntity(
            id = input.id,
            name = "${input.name.first} ${input.name.last}",
            coverImages = input.coverImages,
            categories = createCategories(input.categories),
            logoUrl = input.logoUrl
        )

    }

    private fun createCategories(input: List<CategoryDTO>): List<CategoryEntity> =
        mutableListOf<CategoryEntity>().apply {
            input.forEach {
                add(
                    CategoryEntity(
                        id = it.id,
                        name = it.name,
                        products = mapProduct(it.products)
                    )
                )
            }
        }


    private fun mapProduct(products: List<ProductDTO>): List<FoodEntity> =
        mutableListOf<FoodEntity>().apply {
            products.forEach {
                add(
                    FoodEntity(
                        id = it.id,
                        title = it.title,
                        price = createPrice(it.price),
                        imageUrl = it.imageUrl
                    )
                )
            }
        }

    private fun createPrice(price: PriceDTO): PriceEntity = PriceEntity(
        total = price.total.toDouble(),
        unit = price.unit
    )

}