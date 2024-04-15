package com.example.kktvdemo.com.example.kktvdemo.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kktvdemo.com.example.kktvdemo.api.SearchApi
import com.example.kktvdemo.com.example.kktvdemo.entity.Artist
import javax.inject.Inject


class PagingDataSource @Inject constructor(
    private val service: SearchApi
) : PagingSource<Int, Artist>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Artist> {
        try {
            val nextPageNumber = params.key ?: 0
            val response = service.getSearch(offset = nextPageNumber)
            val artists = response.artists.data
            val prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null
            val nextKey = if (artists.isNotEmpty()) nextPageNumber + 1 else null

            return LoadResult.Page(
                data = artists,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Artist>): Int? {
        return null
    }
}






