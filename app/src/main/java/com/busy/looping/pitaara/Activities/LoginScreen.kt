package com.busy.looping.pitaara.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.busy.looping.pitaara.MainActivity
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {
    lateinit var binding:ActivityLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView
            ?.setOnClickListener {
            var intent= Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }
        binding.loginBtn.setOnClickListener {
            var intent= Intent(this, RegistrationScreen::class.java)
            startActivity(intent)
        }
        binding.loginwithMobile.setOnClickListener {
            var intent= Intent(this, OtpActivity::class.java)
            startActivity(intent)
        }

    }
}