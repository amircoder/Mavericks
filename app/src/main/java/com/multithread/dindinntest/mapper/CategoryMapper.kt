package com.multithread.dindinntest.mapper

import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.data.dto.CategoryDTO
import com.multithread.dindinntest.data.dto.FoodDTO
import com.multithread.dindinntest.data.dto.PriceDTO
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.FoodEntity
import com.multithread.dindinntest.domain.entity.PriceEntity
import javax.inject.Inject

class CategoryMapper @Inject constructor() : OneWayMapper<List<CategoryDTO>, List<CategoryEntity>> {
    override fun map(input: List<CategoryDTO>): List<CategoryEntity> =
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

    private fun mapProduct(products: List<FoodDTO>): List<FoodEntity> =
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
        total = price.total,
        unit = price.unit
    )

}