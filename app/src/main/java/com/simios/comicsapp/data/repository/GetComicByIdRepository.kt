package com.simios.comicsapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.simios.comicsapp.data.database.dao.ComicDao
import com.simios.comicsapp.data.database.entities.ComicEntity
import com.simios.comicsapp.data.model.ComicModel
import com.simios.comicsapp.data.network.GetComicByIdService
import com.simios.comicsapp.domain.model.Comic
import com.simios.comicsapp.domain.model.toDomain
import retrofit2.Response
import javax.inject.Inject


class GetComicByIdRepository @Inject constructor(
    private val api: GetComicByIdService,
    private val comicDao: ComicDao
    ) {

    suspend fun getComicByIdFromApi(comicId: Int): Comic? =
        api.GetCurrentComicService(comicId)?.toDomain()

    suspend fun getComicByIdFromDataBase(): List<Comic> {
        return comicDao.getAllComicts().map { it.toDomain() }
    }

    suspend fun getComicInsert(comic:ComicEntity) {
        return comicDao.insertComic(comic)
    }

    suspend fun clearComics(){
        return comicDao.deleteAllComics()
    }
}

