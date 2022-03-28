package com.simios.comicsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simios.comicsapp.data.model.Comic
import com.simios.comicsapp.domain.GetComicByIdUseCase
import com.simios.comicsapp.domain.GetCurrentComicUseCase
import com.simios.comicsapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ComicsViewModel : ViewModel() {
    val currentComic = MutableLiveData<Resource<Comic>>()
    val lastedComics = MutableLiveData<Comic>()
    var currentComicUseCase = GetCurrentComicUseCase()
    var comicByIdUseCase = GetComicByIdUseCase()

    fun loadCurrentComic() {
        viewModelScope.launch {
            val result = currentComicUseCase()
            currentComic.postValue(handlerGetCurrentComicResponse(result))
        }
    }

    fun loadAfterComic(comicId: Int) {
        for (i in 0..24) {
            viewModelScope.launch {
                val result = comicByIdUseCase(comicId - i)
                if (result.isSuccessful) {
                    result.body()?.let { resultResponse ->
                        lastedComics.postValue(resultResponse)
                    }
                }

            }
        }
    }

    private fun handlerGetCurrentComicResponse(response: Response<Comic>): Resource<Comic> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}