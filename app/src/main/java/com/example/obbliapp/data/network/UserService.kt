package com.example.obbliapp.data.network

import com.example.obbliapp.model.ResponseModel
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    @POST("v2/auth/refresh")
    suspend fun refreshLogin(
        @Header("Authorization") Authorization : String?
    ) : Response<ResponseModel<String>>

    @POST("v2/auth/sign-in")
    suspend fun doLogin(
        @Body request : Login
    ) : Response<ResponseModel<String>>

    @POST("v2/auth/sms")
    suspend fun getCertifyNumber(
        @Body request : String
    ) : Response<ResponseModel<Boolean>>

    @POST("v2/auth/sms/check")
    suspend fun checkCertify(
        @Body request: PhoneCertify
    ) : Response<ResponseModel<Boolean>>

    //type : phone, userId, nickname
    @GET("v2/member/find/{dataType}/{value}")
    suspend fun checkOverlap(
        @Path("dataType") dataType :String,
        @Path("value") value :String
    ) : Response<ResponseModel<Boolean>>



}


data class PhoneCertify(
    val authCode : String,
    val phoneNumber : String
)

data class Login(
    val password : String,
    val userId : String
)