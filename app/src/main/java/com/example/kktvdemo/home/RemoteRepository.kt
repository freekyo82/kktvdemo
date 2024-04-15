package com.example.kktvdemo.com.example.kktvdemo.home

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kktvdemo.com.example.kktvdemo.api.SearchApi
import com.example.kktvdemo.com.example.kktvdemo.entity.Artist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val apiService: SearchApi
) {

    fun getSearchResultStream(): Flow<PagingData<Artist>> {
        return Pager(
            config = PagingConfig(pageSize = 25, enablePlaceholders = false),
            pagingSourceFactory = { PagingDataSource(apiService) }
        )
            .flow
            .flowOn(Dispatchers.IO)
    }

}