package com.example.obbliapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.obbliapp.data.repository.ContentDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContentViewModel  @Inject constructor(private val repository: ContentDataRepository) : ViewModel(){

    fun addContentList(title: String , address:String , distance:String, needPeopleNumber: String) {
        viewModelScope.launch {
            repository.addContents(title,address,distance,needPeopleNumber)
        }
    }
}