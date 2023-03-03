package com.busy.looping.pitaara.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.busy.looping.pitaara.MainActivity
import com.busy.looping.pitaara.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
  lateinit  var binding:ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnHome.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}