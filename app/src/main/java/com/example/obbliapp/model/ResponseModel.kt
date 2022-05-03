package com.example.obbliapp.model

data class ResponseModel<T>(
    //서버 api 데이터에 맞춰서 정해줌 .

    val status: String?,
    val message: String?,
    val data: List<T>
    //  T ? == LIST
)
