package com.busy.looping.pitaara.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.ActivityRecyclviewAddressBinding

class RecyclviewAddressActivity : AppCompatActivity() {
   lateinit var binding:ActivityRecyclviewAddressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRecyclviewAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}