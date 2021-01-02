package com.multithread.dindinntest.domain.repository

import com.multithread.dindinntest.base.SingleBaseRepository
import com.multithread.dindinntest.data.remote.CategoryRemoteDataSource
import com.multithread.dindinntest.domain.entity.CategoryEntity
import io.reactivex.Single
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val categoryRemoteDataSource: CategoryRemoteDataSource
): SingleBaseRepository<List<CategoryEntity>>(){
    override fun getResult(): Single<List<CategoryEntity>> =
    categoryRemoteDataSource.getCategories()

}