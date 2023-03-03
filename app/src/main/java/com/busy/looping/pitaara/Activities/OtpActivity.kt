package com.busy.looping.pitaara.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.busy.looping.pitaara.databinding.ActivityOtpBinding

class OtpActivity : AppCompatActivity() {
  lateinit  var  binding:ActivityOtpBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.generateOtp.setOnClickListener {
            if(binding.etMob.text.toString().isEmpty()&&binding.etMob.text.length!=10)
            {
                Toast.makeText(this,"Please Enter valide number",Toast.LENGTH_SHORT).show()
            }
            else{
                var intent=Intent(this,Otpfields::class.java)
                intent.putExtra("isFromLogin",true)
                intent.putExtra("mno",binding.etMob.text.toString())
                startActivity(intent)
            }

        }

    }
}