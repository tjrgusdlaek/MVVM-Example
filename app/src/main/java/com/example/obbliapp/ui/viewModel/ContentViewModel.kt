package com.example.obbliapp.ui.viewModel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.*

import com.example.obbliapp.data.model.entities.ContentEntity
import com.example.obbliapp.data.repository.ContentDataRepository
import com.example.obbliapp.ui.addContent.AddContentActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ContentViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: ContentDataRepository) : ViewModel() {


    private val _contentList = MutableLiveData<List<ContentEntity>>()
    val contentList: LiveData<List<ContentEntity>> get() = _contentList

    init {
        viewModelScope.launch {
            _contentList.value = (repository.getAllContents())
        }
    }

    fun getContent(){
        viewModelScope.launch {
            _contentList.value = (repository.getAllContents())
        }
    }

    fun deleteContent(id : Int){
        viewModelScope.launch {
           repository.deleteContent(id)
        }
    }

    fun addContent(contentEntity: ContentEntity) {
        viewModelScope.launch {
            repository.addContents(contentEntity)
        }
    }

    fun move(){
        val intent = Intent(context, AddContentActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
}