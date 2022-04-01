package com.example.obbliapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.obbliapp.databinding.ActivityLoginBinding
import com.example.obbliapp.ui.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.activity = this
        binding.viewModel = viewModel

    }

    fun loginApp(view : View){
        if (binding.editTextID.text.toString().isEmpty() || binding.editTextPassword.text.toString().isEmpty()) {
            Toast.makeText(this, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            return
        } else {
            viewModel.buttonClickListener(binding.editTextID.text.toString(),binding.editTextPassword.text.toString())
        }
    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}