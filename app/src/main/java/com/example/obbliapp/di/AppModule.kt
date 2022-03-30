package com.example.obbliapp.di

import android.content.Context
import androidx.room.Room
import com.example.obbliapp.data.local.ContentDao
import com.example.obbliapp.data.repository.ContentDataRepository
import com.example.obbliapp.data.local.ContentDatabase
import com.example.obbliapp.data.domain.SaveDataStore
import com.example.obbliapp.data.domain.SaveContentData
import com.example.obbliapp.data.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ): DataStoreRepository = SaveDataStore(context)

    @Singleton
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideRepository(
        ContentDao: ContentDao, ioDispatcher: CoroutineDispatcher): ContentDataRepository =
        SaveContentData(ContentDao,ioDispatcher)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ContentDatabase {
        return Room.databaseBuilder(appContext, ContentDatabase::class.java, "local.db").build()
    }

    @Provides
    fun provideContentDao(database: ContentDatabase): ContentDao {
        return database.ContentDao()
    }
}
