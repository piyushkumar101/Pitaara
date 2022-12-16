package com.busy.looping.pitaara.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.ActivityQrBinding

class QrActivity : AppCompatActivity() {
   lateinit var binding:ActivityQrBinding
    var  url:String=" ";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQrBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val getImage = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {

                 url = it.toString()
                buttonEnable(url)
                // Toast.makeText(context,it.toString(),Toast.LENGTH_SHORT).show()
            }
        );
        binding.btnChooseScreenshot.setOnClickListener {
            getImage.launch("image/*")
        }

        binding.btnSubmit.isVisible=false

    }

    private fun buttonEnable(url: String) {
        if(url.isEmpty())
        {
            binding.btnSubmit.isVisible=false
        }
        else{
            binding.btnSubmit.isVisible=true
        }
    }
}