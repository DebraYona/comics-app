package com.simios.comicsapp.domain

import com.simios.comicsapp.data.database.entities.toDatabase
import com.simios.comicsapp.data.repository.GetCurrentComicRepository
import com.simios.comicsapp.domain.model.Comic
import javax.inject.Inject

class GetCurrentComicUseCase @Inject constructor(private val repository: GetCurrentComicRepository) {

    suspend operator fun invoke(): Comic {
        val comic = repository.getCurrentComicRepository()
        return if (comic != null){
            repository.getComicInsert(comic.toDatabase())
            comic
        }else {
            repository.getCurrentComic()
        }
    }
}