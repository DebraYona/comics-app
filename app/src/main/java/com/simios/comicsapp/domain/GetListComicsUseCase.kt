package com.simios.comicsapp.domain

import com.simios.comicsapp.data.database.entities.toDatabase
import com.simios.comicsapp.data.repository.GetComicByIdRepository
import com.simios.comicsapp.domain.model.Comic
import javax.inject.Inject

class GetListComicUseCase @Inject constructor(private val repository: GetComicByIdRepository) {

    suspend operator fun invoke(currentComicId: Int): List<Comic> {
        val comics: MutableList<Comic> = mutableListOf()
        //repository.clearComics()
        for (i in 0..24) {
            val comic = repository.getComicByIdFromApi(currentComicId-i)
            if (comic != null){
                repository.getComicInsert(comic.toDatabase())
                comics.add(comic)
            }
        }
        return if (comics.isNotEmpty()){
            comics
        } else{
            repository.getComicByIdFromDataBase()
        }
    }
}