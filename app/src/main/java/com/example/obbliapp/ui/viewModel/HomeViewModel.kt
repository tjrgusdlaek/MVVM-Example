package com.example.obbliapp.ui.viewModel

import android.content.Context
import androidx.lifecycle.*

import com.example.obbliapp.R
import com.example.obbliapp.data.entities.ContentEntity
import com.example.obbliapp.data.repository.ContentDataRepository
import com.example.obbliapp.data.repository.MoveRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: ContentDataRepository,
    private val MoveRepository: MoveRepository) : ViewModel() {


    private val _contentList = MutableLiveData<List<ContentEntity>>()
    val contentList: LiveData<List<ContentEntity>> get() = _contentList

    init {
        viewModelScope.launch {
            _contentList.value = (repository.getAllContents())
        }
    }

    fun move(){
        MoveRepository.moveToAddContent(context)
    }
}