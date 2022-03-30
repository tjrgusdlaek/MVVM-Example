package com.example.obbliapp.data.domain


import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.example.obbliapp.data.repository.DataStoreRepository
import com.example.obbliapp.ui.main.MainActivity
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SaveDataStore @Inject constructor(private val context: Context) : DataStoreRepository {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name =  "autoLogin")


    override suspend fun putID(key: String, value: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun putPassword(key: String, value: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }

    }
    override suspend fun putCheckBox(key: String, value: Boolean) {
        val preferencesKey = booleanPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun getID(key: String): String? {
        return try {
            val preferencesKey = stringPreferencesKey(key)
            val preferences = context.dataStore.data.first()
            preferences[preferencesKey]
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }

    override suspend fun getPassword(key: String): String? {
        return try {
            val preferencesKey = stringPreferencesKey(key)
            val preferences = context.dataStore.data.first()
            preferences[preferencesKey]
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }

    override suspend fun getCheckBox(key: String): Boolean? {
        return try {
            val preferencesKey = booleanPreferencesKey(key)
            val preferences = context.dataStore.data.first()
            preferences[preferencesKey]?: false
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }

    override suspend fun buttonClickListener(Id: String, Password: String, Check: Boolean) {
            putID("ID",Id)
            putPassword("Password",Password)
            if (Check) putCheckBox("check" , true) else putCheckBox("check", false)
            login()
    }

    override fun login() {
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
}