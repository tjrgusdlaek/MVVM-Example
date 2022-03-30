package com.example.obbliapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.obbliapp.data.entities.ContentEntity


@Database(entities = [ContentEntity::class], version = 1, exportSchema = false)
abstract class ContentDatabase : RoomDatabase() {
    abstract fun ContentDao(): ContentDao
}
