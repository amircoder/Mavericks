package com.multithread.dindinntest.mapper

import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.data.dto.VenueDTO
import com.multithread.dindinntest.domain.entity.VenueEntity
import javax.inject.Inject

class VenueMapper @Inject constructor(): OneWayMapper<List<VenueDTO>, List<VenueEntity>> {
    override fun map(input: List<VenueDTO>): List<VenueEntity> =
        mutableListOf<VenueEntity>().apply {
            input.forEach {
                add(
                    VenueEntity(
                        id = it.id,
                        name = it.name,
                        coverImages = it.coverImages,
                        logoUrl = it.logoUrl
                    )
                )
            }
        }

}