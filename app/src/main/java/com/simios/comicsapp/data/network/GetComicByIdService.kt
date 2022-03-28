package com.simios.comicsapp.data.network

import com.simios.comicsapp.data.model.ComicModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GetComicByIdService @Inject constructor(private val api: XkcdApiClient) {
    suspend fun GetCurrentComicService(comicId: Int): ComicModel? {
        return withContext(Dispatchers.IO) {
            val response = api.getComicById(comicId)
            response.body()
        }
    }
}