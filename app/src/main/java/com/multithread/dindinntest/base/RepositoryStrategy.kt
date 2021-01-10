package com.multithread.dindinntest.base

sealed class RepositoryStrategy {
    object Local: RepositoryStrategy()
    object OfflineFirst : RepositoryStrategy()
    object Remote : RepositoryStrategy()
}