package com.example.obbliapp.data.repository


interface UserRepository{

    fun setLoginId(id : String)

    //SharedPreference
//    suspend fun checkLogin() : Boolean
//    suspend fun doLogin(login : Login) : Boolean
//    suspend fun getCertifyNumber(phone : String) : Boolean
//    suspend fun checkCertify(body : PhoneCertify) : Boolean
//    suspend fun checkOverlap(type : String, value : String) : Boolean
//    suspend fun signUp(body : SignUpData) : Boolean

    fun setOnBoardingOption()
    fun checkOnBoarding() : Boolean
}