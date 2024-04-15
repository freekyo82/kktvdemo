package com.example.kktvdemo.com.example.kktvdemo.api


import com.example.kktvdemo.com.example.kktvdemo.entity.ArtistResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SearchApi {
    @GET("v1.1/search")
    suspend fun getSearch(
        @Header("Authorization") authorization: String = "Bearer xwHop0wxeKCtynQ9kTdoZw==",
        @Query("q") searchName: String = "周杰倫",
        @Query("type") searchType: String = "artist",
        @Query("territory") territory: String = "TW",
        @Query("offset") offset: Int
    ): ArtistResponse

}
