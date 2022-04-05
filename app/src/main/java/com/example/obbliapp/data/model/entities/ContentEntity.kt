package com.example.obbliapp.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content")
data class ContentEntity(val title: String, val address: String,val distance:String,val needPeopleNumber:String ) {
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0

}