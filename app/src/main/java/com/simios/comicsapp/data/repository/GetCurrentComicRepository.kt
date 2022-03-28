package com.simios.comicsapp.data.repository

import com.simios.comicsapp.data.model.Comic
import com.simios.comicsapp.data.network.GetCurrentComicService
import retrofit2.Response
import javax.inject.Inject

class GetCurrentComicRepository @Inject constructor(private val api: GetCurrentComicService) {

    suspend fun getCurrentComicRepository(): Response<Comic> {
        return api.getCurrentComicService()
    }
}