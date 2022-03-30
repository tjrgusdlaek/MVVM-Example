package com.example.obbliapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.obbliapp.data.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: DataStoreRepository) : ViewModel(){

    var checkBox =MutableLiveData<Boolean>()

    init {
        if (getCheckBox()==true){
            repository.login()
        }else{
            checkBox.value = false
        }
    }

//    fun saveID(value: String) {
//        viewModelScope.launch {
//            repository.putID("ID", value)
//        }
//    }
//
//    fun getID(): String? = runBlocking {
//        repository.getID("ID")
//    }
//
//    fun savePassword(value: String) {
//        viewModelScope.launch {
//            repository.putPassword("Password", value)
//        }
//    }
//
//    fun getPassword(): String? = runBlocking {
//        repository.getPassword("Password")
//    }
//
//    fun saveCheckBox(value: Boolean){
//        viewModelScope.launch {
//            repository.putCheckBox("check", value)
//        }
//    }

    fun checkValue() {
        checkBox.value = checkBox.value != true
    }

    fun getCheckBox(): Boolean? = runBlocking {
        repository.getCheckBox("check")
    }

     fun login() {
        repository.login()
    }

    fun buttonClickListener(textId: String, textPassword: String){
        viewModelScope.launch {
            repository.buttonClickListener(textId, textPassword,  checkBox.value?: false)
        }
    }
}

