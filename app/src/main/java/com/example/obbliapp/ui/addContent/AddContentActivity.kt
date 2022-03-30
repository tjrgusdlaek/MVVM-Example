package com.example.obbliapp.ui.addContent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.obbliapp.R
import com.example.obbliapp.databinding.ActivityAddContentBinding
import com.example.obbliapp.databinding.ActivityMainBinding
import com.example.obbliapp.ui.main.MainActivity
import com.example.obbliapp.viewModel.AddContentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddContentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddContentBinding
    private val viewModel: AddContentViewModel by viewModels()

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
        viewModel.addContentList(title,address,distance,needNumber)
        Toast.makeText(this, "저장되었습니다." ,Toast.LENGTH_SHORT).show()

        binding.etTitle.setText("")
        binding.etAddress.setText("")
        binding.etDistance.setText("")
        binding.etNeedPersonNumber.setText("")
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        super.onBackPressed()
    }
}