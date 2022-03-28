package com.simios.comicsapp.data.repository

import com.simios.comicsapp.data.model.Comic
import com.simios.comicsapp.data.network.GetComicByIdService
import retrofit2.Response

class GetComicByIdRepository {
    private val api = GetComicByIdService()

    suspend fun getComicByIdRepository(comicId: Number): Response<Comic> {
        return api.GetCurrentComicService(comicId)
    }
}