package com.simios.comicsapp.domain

import com.simios.comicsapp.data.repository.GetCurrentComicRepository
import javax.inject.Inject

class GetCurrentComicUseCase @Inject constructor(private val repository: GetCurrentComicRepository) {

    suspend operator fun invoke() = repository.getCurrentComicRepository()
}