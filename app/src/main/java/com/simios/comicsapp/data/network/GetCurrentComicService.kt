package com.simios.comicsapp.data.network

import com.simios.comicsapp.core.RetrofitHelper
import com.simios.comicsapp.data.model.Comic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class GetCurrentComicService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun GetCurrentComicService(): Response<Comic> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(XkcdApiClient::class.java).getCurrentComic()
            response
        }
    }
}