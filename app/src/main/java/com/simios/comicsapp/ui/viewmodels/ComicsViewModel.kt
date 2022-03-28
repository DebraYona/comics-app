package com.simios.comicsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simios.comicsapp.domain.GetCurrentComicUseCase
import com.simios.comicsapp.domain.GetListComicUseCase
import com.simios.comicsapp.domain.model.Comic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val currentComicUseCase: GetCurrentComicUseCase,
    private val listComics: GetListComicUseCase
) : ViewModel() {
    val currentComic = MutableLiveData<Comic>()
    val lastedComics: MutableLiveData<List<Comic>?> = MutableLiveData()

    fun loadCurrentComic() {
        viewModelScope.launch {
            val result = currentComicUseCase()
            currentComic.postValue(result)
        }
    }

    fun loadAfterComic(comicId: Int) {
        viewModelScope.launch {
            lastedComics.postValue(listComics(comicId))
        }
    }

}