package com.simios.comicsapp.data.network

import com.simios.comicsapp.data.model.ComicModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface XkcdApiClient {
    @GET("info.0.json")
    suspend fun getCurrentComic(
    ): Response<ComicModel>

    @GET("{comicsId}/info.0.json")
    suspend fun getComicById(
        @Path("comicsId") comicsId: Int
    ): Response<ComicModel>
}