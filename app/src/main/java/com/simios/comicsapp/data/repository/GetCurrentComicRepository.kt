package com.simios.comicsapp.data.repository

import com.simios.comicsapp.data.database.dao.ComicDao
import com.simios.comicsapp.data.database.entities.ComicEntity
import com.simios.comicsapp.data.model.ComicModel
import com.simios.comicsapp.data.network.GetCurrentComicService
import com.simios.comicsapp.domain.model.Comic
import com.simios.comicsapp.domain.model.toDomain
import retrofit2.Response
import javax.inject.Inject

class GetCurrentComicRepository @Inject constructor(
    private val api: GetCurrentComicService,
    private val comicDao: ComicDao
) {

    suspend fun getCurrentComicRepository(): Comic? {
        return api.getCurrentComicService()?.toDomain()
    }

    suspend fun getComicInsert(comic: ComicEntity) {
        return comicDao.insertComic(comic)
    }
    suspend fun getCurrentComic(): Comic {
        return comicDao.getAllComicts()[0].toDomain()
    }
}