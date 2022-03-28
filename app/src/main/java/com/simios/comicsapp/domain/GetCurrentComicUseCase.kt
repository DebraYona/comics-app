package com.simios.comicsapp.domain

import com.simios.comicsapp.data.repository.GetCurrentComicRepository

class GetCurrentComicUseCase {
    private val repository = GetCurrentComicRepository()

    suspend operator fun invoke() = repository.getCurrentComicRepository()
}