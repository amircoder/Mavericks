package com.multithread.dindinntest.base

interface ErrorContainer {
    fun getError(throwable: Throwable): ErrorEntity
}