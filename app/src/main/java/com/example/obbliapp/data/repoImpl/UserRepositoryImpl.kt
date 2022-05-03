package com.example.obbliapp.data.repoImpl

import android.content.SharedPreferences
import android.util.Log
import com.example.obbliapp.data.network.Login
import com.example.obbliapp.data.network.UserService
import com.example.obbliapp.data.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl@Inject constructor(
    private val userService: UserService,
    private val userSharedPreferences: SharedPreferences
) : UserRepository {

//    override suspend fun checkLogin(): Boolean {
//        val data =  userService.refreshLogin(userSharedPreferences.getString("token", null))
//
//        return when(data.isSuccessful){
//            true->{
//                if(data.body()?.data != null) {
//                    userSharedPreferences.edit().putString("token", "Bearer ${data.body()!!.data}").apply()
//                    true
//                }
//                else
//                    false
//            }
//            false->{
//                false
//            }
//        }
//    }
//
//    override suspend fun doLogin(login : Login) : Boolean{
//        val data = userService.doLogin(login)
//
//        return when(data.isSuccessful){
//            true -> {
//                Log.d("testing", data.body().toString())
//                if(data.body()?.data != null){
//                    userSharedPreferences.edit().putString("token", "Bearer ${data.body()!!.data}").apply()
//                    true
//                }
//                else
//                    false
//            }
//            else -> false
//        }
//
//    }
//
//    override suspend fun getCertifyNumber(phone: String): Boolean {
//        val data = userService.getCertifyNumber(phone)
//
//        return when(data.isSuccessful){
//            true -> {
//                data.body()?.data == true
//            }
//            else -> false
//        }
//    }
//
//    override suspend fun checkCertify(body: PhoneCertify): Boolean {
//        val data = userService.checkCertify(body)
//
//        return when(data.isSuccessful){
//            true -> {
//                data.body()?.data == true
//            }
//            else -> false
//        }
//    }
//
//    override suspend fun checkOverlap(type: String, value: String): Boolean {
//        val data = userService.checkOverlap(type, value)
//
//        return when(data.isSuccessful){
//            true -> {
//                data.body()?.data != true
//            }
//            else -> false
//        }
//    }
//
//    override suspend fun signUp(body: SignUpData): Boolean {
//        val data = userService.singUp(body)
//
//        return when(data.isSuccessful){
//            true -> {
//                if(data.body()?.data != null) {
//                    userSharedPreferences.edit().putString("token", "Bearer ${data.body()!!.data}").apply()
//                    true
//                }
//                else
//                    false
//            }
//            else -> false
//        }
//    }

    override fun checkOnBoarding(): Boolean {
        return userSharedPreferences.getBoolean("onboard", true)
    }
    override fun setOnBoardingOption() {
        userSharedPreferences.edit().putBoolean("onboard",false).apply()
    }

    override fun setLoginId(id: String) {
        userSharedPreferences.edit().putString("user",id).apply()
    }

}