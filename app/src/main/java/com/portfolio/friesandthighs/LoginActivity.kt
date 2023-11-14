package com.portfolio.friesandthighs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.portfolio.friesandthighs.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.dontHaveTxt.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}