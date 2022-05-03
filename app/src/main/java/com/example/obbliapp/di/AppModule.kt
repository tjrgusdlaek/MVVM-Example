package com.example.obbliapp.di

import android.content.Context
import androidx.room.Room
import com.example.obbliapp.data.repository.ContentDataRepository
import com.example.obbliapp.data.dataSources.DataStoreSources
import com.example.obbliapp.data.dataSources.ContentDataSources
import com.example.obbliapp.model.ContentDao
import com.example.obbliapp.data.database.ContentDatabase
import com.example.obbliapp.data.network.UserService
import com.example.obbliapp.data.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseRetrofit

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    //Retrofit 사용할 때

//    @Provides
//    fun provideBaseUrl() = "URL"
//
//    @Singleton
//    @Provides
//    @BaseRetrofit
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl(provideBaseUrl())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//
//    @Provides
//    @Singleton
//    fun provideUserService(@BaseRetrofit retrofit: Retrofit) : UserService{
//        return retrofit.create(UserService::class.java)
//    }



    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ): DataStoreRepository = DataStoreSources(context)

//    @Singleton
//    @Provides
//    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideRepository(
        ContentDao: ContentDao): ContentDataRepository =
        ContentDataSources(ContentDao)

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
