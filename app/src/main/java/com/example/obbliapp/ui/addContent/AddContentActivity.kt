package com.example.obbliapp.ui.addContent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.obbliapp.data.entities.ContentEntity
import com.example.obbliapp.databinding.ActivityAddContentBinding
import com.example.obbliapp.ui.viewModel.ContentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddContentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddContentBinding
    private val viewModel: ContentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.activity =this
        binding.viewModel = viewModel
    }

    fun addContent(view : View){
        val title = binding.etTitle.text.toString()
        val address = binding.etAddress.text.toString()
        val distance = binding.etDistance.text.toString()
        val needNumber = binding.etNeedPersonNumber.text.toString()

        val contentEntity = ContentEntity(title,address,distance,needNumber)
        viewModel.addContent(contentEntity)

        Toast.makeText(this, "저장되었습니다." ,Toast.LENGTH_SHORT).show()
        binding.etTitle.setText("")
        binding.etAddress.setText("")
        binding.etDistance.setText("")
        binding.etNeedPersonNumber.setText("")
    }
}