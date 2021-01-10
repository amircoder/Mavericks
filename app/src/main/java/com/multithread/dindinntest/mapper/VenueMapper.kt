package com.multithread.dindinntest.mapper

import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.data.dto.VenueDTO
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.FoodEntity
import com.multithread.dindinntest.domain.entity.PriceEntity
import com.multithread.dindinntest.domain.entity.VenueEntity
import javax.inject.Inject

class VenueMapper @Inject constructor() : OneWayMapper<List<VenueDTO>, List<VenueEntity>> {
    override fun map(input: List<VenueDTO>): List<VenueEntity> =
            mutableListOf<VenueEntity>().apply {
                input.forEach {
                    add(
                            VenueEntity(
                                    id = it.id,
                                    name = "${it.name.first} ${it.name.last}",
                                    coverImages = it.coverImages,
                                    categories = createCategories(it.categories),
                                    logoUrl = it.logoUrl
                            )
                    )
                }
            }

    private fun createCategories(input: List<VenueDTO.Category>): List<CategoryEntity> =
            mutableListOf<CategoryEntity>().apply {
                input.forEach {
                    add(CategoryEntity(
                            id = it.id,
                            name = it.name,
                            products = mapProduct(it.products)
                    ))
                }
            }


    private fun mapProduct(products: List<VenueDTO.Product>): List<FoodEntity> =
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

    private fun createPrice(price: VenueDTO.Price): PriceEntity = PriceEntity(
            total = price.total,
            unit = price.unit
    )

}