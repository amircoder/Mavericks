package com.multithread.dindinntest.data.remote

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.multithread.dindinntest.BuildConfig
import com.multithread.dindinntest.base.BaseDataSource
import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.data.ProductApi
import com.multithread.dindinntest.data.dto.DeliveryDTO
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.multithread.dindinntest.util.LocalStorageUtils
import io.reactivex.Single
import javax.inject.Inject

interface VenueRemoteDataSource : BaseDataSource {
    fun getVenueList(): Single<List<VenueEntity>>
}

class VenueRemoteDataSourceImpl @Inject constructor(
    private val context: Context,
    private val api: ProductApi,
    private val mapper: OneWayMapper<DeliveryDTO, VenueEntity>
) : VenueRemoteDataSource {
    override fun getVenueList(): Single<List<VenueEntity>> {
        return if (BuildConfig.DEMO) {
            Single.just(
                mutableListOf<VenueEntity>().apply {
                    Log.d("crashTag", "got local VenueList: ${getLocalData()}")
                    getLocalData().forEach {
                        add(
                            mapper.map(it)
                        )
                    }
                }
            )
        } else {
            api.getVenueList().map { deliveryItemList ->
                Log.d("crashTag", "got VenueList: $deliveryItemList")
                val output = mutableListOf<VenueEntity>()
                try {
                    deliveryItemList.forEach { deliveryItem ->
                        output.add(
                            mapper.map(deliveryItem)
                        )
                    }
                } catch (exception: Exception) {
                    Log.e("crashTag", "getVenueList: mapper has problem ", exception)
                    exception.printStackTrace()
                }
                output
                listOf<VenueEntity>(VenueEntity("", "", listOf(), listOf(), ""))
            }
        }
    }

    private fun getLocalData(): List<DeliveryDTO> = Gson().fromJson(
        LocalStorageUtils.readJsonFromFileAssets(context, "venue_data.json"),
        object : TypeToken<List<DeliveryDTO>>() {}.type
    )
}
