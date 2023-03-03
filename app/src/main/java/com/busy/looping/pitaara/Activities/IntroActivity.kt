package com.busy.looping.pitaara.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.busy.looping.pitaara.Fragments.OnboardingFragments.OnboardingFrag1
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.ActivityIntroBinding
import com.busy.looping.pitaara.databinding.ActivityMainBinding

class IntroActivity : AppCompatActivity() {
   lateinit var  binding:ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(
            R.id.OnBoardingFrgementView,
            OnboardingFrag1()
        ).commitNow()
    }
}