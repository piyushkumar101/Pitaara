package com.busy.looping.pitaara.Activities

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.busy.looping.pitaara.MainActivity
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.ActivityOtpBinding
import com.busy.looping.pitaara.databinding.ActivityOtpfieldsBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class Otpfields : AppCompatActivity() {
    lateinit var binding: ActivityOtpfieldsBinding
    lateinit var auth: FirebaseAuth
    private var verificationId: String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOtpfieldsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        var mob=intent


        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+91${mob.getStringExtra("mno")}")       // Phone number to verify
            .setTimeout(60, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    val code: String? = p0.smsCode
                    binding.pinView.setText(code)
                }

                override fun onVerificationFailed(p0: FirebaseException) {
                    Toast.makeText(applicationContext, p0.toString(), Toast.LENGTH_LONG).show()
                }

                override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                    super.onCodeSent(p0, p1)
                    verificationId = p0;
                }
            })          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        binding.btnSignin.setOnClickListener {
            if (binding.pinView.text?.length == 6 && binding.pinView.text == null) {
                Toast.makeText(this, "Please Enter 6 digit ", Toast.LENGTH_SHORT).show()
            } else {
                val credential =
                    PhoneAuthProvider.getCredential(verificationId, binding.pinView.text.toString())
                auth.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val user = it.result?.user
                        val intent = Intent(applicationContext,     MainActivity::class.java)
                        intent.putExtra("UID", user)
                        startActivity(intent)
                    } else {
                        // Sign in failed, display a message and update the UI
                        Log.w(ContentValues.TAG, "signInWithCredential:failure", it.exception)
                        if (it.exception is FirebaseAuthInvalidCredentialsException) {
                            Toast.makeText(applicationContext, "Otp is wrong", Toast.LENGTH_SHORT)
                                .show()
                        }
                        // Update UI
                    }
                }
            }
        }

    }
}


