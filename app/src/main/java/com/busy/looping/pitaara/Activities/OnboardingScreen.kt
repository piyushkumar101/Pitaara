package com.busy.looping.pitaara.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.busy.looping.pitaara.R

class OnboardingScreen : AppCompatActivity() {
    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_screen)
        init()
    }

    private fun init () {
        viewPager = findViewById(R.id.viewPager)
    }
}