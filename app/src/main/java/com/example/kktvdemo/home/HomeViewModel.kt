package com.example.kktvdemo.com.example.kktvdemo.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kktvdemo.com.example.kktvdemo.entity.Artist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class HomeViewModel @Inject constructor(
  private val remoteRepository: RemoteRepository
) : ViewModel() {

  fun getSearchResult(): Flow<PagingData<Artist>> {
    return remoteRepository
      .getSearchResultStream()
      .flowOn(Dispatchers.Main)
      .cachedIn(viewModelScope)
  }
}