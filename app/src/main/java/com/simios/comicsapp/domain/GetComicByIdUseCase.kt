package com.simios.comicsapp.domain

import com.simios.comicsapp.data.repository.GetComicByIdRepository
import javax.inject.Inject

class GetComicByIdUseCase @Inject constructor(private val repository: GetComicByIdRepository) {

    suspend operator fun invoke(ComicId: Number) = repository.getComicByIdRepository(ComicId)

}