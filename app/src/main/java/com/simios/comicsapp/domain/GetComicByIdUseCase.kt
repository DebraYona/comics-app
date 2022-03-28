package com.simios.comicsapp.domain

import com.simios.comicsapp.data.repository.GetComicByIdRepository
import com.simios.comicsapp.data.repository.GetCurrentComicRepository

class GetComicByIdUseCase {
    private val repository = GetComicByIdRepository()

    suspend operator fun invoke(ComicId: Number) = repository.getComicByIdRepository(ComicId)

}