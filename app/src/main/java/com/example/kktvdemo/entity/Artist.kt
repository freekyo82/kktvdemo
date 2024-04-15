package com.example.kktvdemo.com.example.kktvdemo.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistResponse(
    @Json(name = "artists") val artists: ArtistsData,
    @Json(name = "summary") val summary: Summary,
    @Json(name = "paging") val paging: Paging
)

@JsonClass(generateAdapter = true)
data class ArtistsData(
    @Json(name = "data") val data: List<Artist>,
    @Json(name = "paging") val paging: Paging
)

@JsonClass(generateAdapter = true)
data class Artist(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
    @Json(name = "images") val images: List<Image>
){
    val artistImageUrl:String
        get() = images[0].url
}

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "height") val height: Int,
    @Json(name = "width") val width: Int,
    @Json(name = "url") val url: String
)

@JsonClass(generateAdapter = true)
data class Paging(
    @Json(name = "offset") val offset: Int,
    @Json(name = "limit") val limit: Int,
    @Json(name = "previous") val previous: String?,
    @Json(name = "next") val next: String?
)

@JsonClass(generateAdapter = true)
data class Summary(
    @Json(name = "total") val total: Int
)
