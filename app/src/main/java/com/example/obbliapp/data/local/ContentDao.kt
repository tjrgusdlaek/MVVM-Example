package com.example.obbliapp.data.local

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.obbliapp.data.entities.ContentEntity


@Dao
interface ContentDao {

    @Query("SELECT * FROM content ORDER BY id DESC")
    fun getAll(): List<ContentEntity>

    @Insert
    fun insert(vararg ContentEntity: ContentEntity)

    @Query("DELETE FROM content WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM content WHERE id = :id")
    fun selectContentById(id: Long): Int

    @Query("SELECT * FROM content ORDER BY id DESC")
    fun selectAllLogsCursor(): Cursor

}
