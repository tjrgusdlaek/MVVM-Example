package com.example.obbliapp.data.repository

import com.example.obbliapp.data.entities.ContentEntity


interface ContentDataRepository {
    suspend fun addContents(title: String, address: String, distance:String , number:String)
    suspend fun getAllContents() :List<ContentEntity>
    suspend fun deleteContent(id : Int)
}