package com.example.obbliapp.viewModel

import androidx.lifecycle.*

import com.example.obbliapp.R
import com.example.obbliapp.data.entities.ContentEntity
import com.example.obbliapp.data.repository.ContentDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ContentDataRepository) : ViewModel() {


    private val _contentList = MutableLiveData<List<ContentEntity>>()
    val contentList: LiveData<List<ContentEntity>> get() = _contentList

    init {
        viewModelScope.launch {
            _contentList.value = (repository.getAllContents())
        }
    }

}