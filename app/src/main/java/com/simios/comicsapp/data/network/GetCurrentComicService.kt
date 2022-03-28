package com.simios.comicsapp.data.network

import com.simios.comicsapp.data.model.ComicModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GetCurrentComicService @Inject constructor(private val api: XkcdApiClient) {

    suspend fun getCurrentComicService(): ComicModel? {
        return withContext(Dispatchers.IO) {
            val response = api.getCurrentComic()
            response.body()
        }
    }
}