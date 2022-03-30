package com.example.obbliapp.data.domain


import android.app.Activity
import android.content.Intent
import com.example.obbliapp.data.repository.HomeRepository
import com.example.obbliapp.ui.addContent.AddContentActivity
import javax.inject.Inject

class HomeImplement @Inject constructor(private val context: Activity) : HomeRepository {

    override fun moveToAddContent() {
        val intent = Intent(context, AddContentActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
}