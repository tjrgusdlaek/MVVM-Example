package com.example.obbliapp.data.dataSources

import com.example.obbliapp.data.entities.ContentEntity
import com.example.obbliapp.data.local.ContentDao
import com.example.obbliapp.data.repository.ContentDataRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

import javax.inject.Inject

class ContentDataSources @Inject constructor(private val contentDao: ContentDao, private val ioDispatcher : CoroutineDispatcher,) :
    ContentDataRepository {

    override suspend fun addContents(title: String, address: String, distance:String , number:String) = withContext(ioDispatcher){
        contentDao.insert(
            ContentEntity(title,address,distance,number)
        )
    }

    override suspend fun getAllContents(): List<ContentEntity> = withContext(ioDispatcher) {
        contentDao.getAll()
    }

    override suspend fun deleteContent(id : Int)= withContext(ioDispatcher) {
        contentDao.delete(id)
    }
}