package com.busy.looping.pitaara.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.ActivityRegistrationScreenBinding

class RegistrationScreen : AppCompatActivity() {
   lateinit var binding:ActivityRegistrationScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistrationScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegistration?.setOnClickListener {
            var intent=Intent(this,Otpfields::class.java)
            intent.putExtra("isFromLogin",false)
            startActivity(intent)
        }

    }
}