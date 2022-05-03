package com.example.obbliapp.data.repository

import com.example.obbliapp.data.entities.ContentEntity


interface ContentDataRepository {
    suspend fun addContents(contentEntity: ContentEntity)
    suspend fun getAllContents() :List<ContentEntity>
    suspend fun deleteContent(id : Int)
}