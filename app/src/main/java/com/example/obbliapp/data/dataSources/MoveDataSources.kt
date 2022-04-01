package com.example.obbliapp.data.dataSources


import android.content.Context
import android.content.Intent
import com.example.obbliapp.data.repository.MoveRepository
import com.example.obbliapp.ui.addContent.AddContentActivity
import javax.inject.Inject

class MoveDataSources @Inject constructor() : MoveRepository {

    override fun moveToAddContent(context: Context) {
        val intent = Intent(context, AddContentActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
}