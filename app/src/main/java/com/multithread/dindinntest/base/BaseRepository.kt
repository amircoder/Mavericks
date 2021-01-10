package com.multithread.dindinntest.base

import io.reactivex.Single

interface BaseRepository<T>{
    fun getResult(): T
}

abstract class SingleBaseRepository<T>: BaseRepository<Single<T>>
