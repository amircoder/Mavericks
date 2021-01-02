package com.multithread.dindinntest.base

interface OneWayMapper<L, R> {
    fun map(input: L): R
}
