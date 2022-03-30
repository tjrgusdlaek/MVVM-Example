package com.example.obbliapp.data.repository

interface DataStoreRepository {
    suspend fun putID(key: String, value: String)
    suspend fun putPassword(key: String, value: String)
    suspend fun putCheckBox(key: String, value: Boolean)
    suspend fun getID(key: String): String?
    suspend fun getPassword(key: String): String?
    suspend fun getCheckBox(key: String): Boolean?
    suspend fun buttonClickListener(id: String, password: String, check: Boolean)
    fun login()
}