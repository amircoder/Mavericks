package com.multithread.dindinntest.data.remote

import com.multithread.dindinntest.base.BaseDataSource
import com.multithread.dindinntest.base.OneWayMapper
import com.multithread.dindinntest.base.ResultResponse
import com.multithread.dindinntest.data.ProductApi
import com.multithread.dindinntest.data.dto.CategoryDTO
import com.multithread.dindinntest.domain.entity.CategoryEntity
import io.reactivex.Single

interface CategoryRemoteDataSource : BaseDataSource {
    fun getCategories(): Single<ResultResponse<List<CategoryEntity>>>
}

class CategoryRemoteDataSourceImpl(
    private val api: ProductApi,
    private val mapper: OneWayMapper<List<CategoryDTO>, List<CategoryEntity>>
) : CategoryRemoteDataSource {
    override fun getCategories(): Single<ResultResponse<List<CategoryEntity>>> =
        api.getCategoryList().map {
            ResultResponse.Success(
                mapper.map(it)
            )
        }

}
