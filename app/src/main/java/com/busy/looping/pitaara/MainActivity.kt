package com.busy.looping.pitaara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        val displayMetrics = DisplayMetrics()

        setContentView(R.layout.product_desc)
    }
}