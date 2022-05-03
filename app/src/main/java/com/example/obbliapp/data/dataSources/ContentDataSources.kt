package com.example.obbliapp.data.dataSources

import com.example.obbliapp.data.entities.ContentEntity
import com.example.obbliapp.model.ContentDao
import com.example.obbliapp.data.repository.ContentDataRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import javax.inject.Inject

class ContentDataSources @Inject constructor(private val contentDao: ContentDao) :
    ContentDataRepository {

    override suspend fun addContents(contentEntity: ContentEntity) = withContext(Dispatchers.IO){
        contentDao.insert(contentEntity)
    }

    override suspend fun getAllContents(): List<ContentEntity> = withContext(Dispatchers.IO) {
        contentDao.getAll()
    }

    override suspend fun deleteContent(id : Int)= withContext(Dispatchers.IO) {
        contentDao.delete(id)
    }
}