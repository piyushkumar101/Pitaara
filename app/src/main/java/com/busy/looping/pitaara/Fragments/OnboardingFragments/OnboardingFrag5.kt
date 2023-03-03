package com.busy.looping.pitaara.Fragments.OnboardingFragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.busy.looping.pitaara.Activities.LoginScreen
import com.busy.looping.pitaara.MainActivity
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.FragmentOnboardingFrag4Binding
import com.busy.looping.pitaara.databinding.FragmentOnboardingFrag5Binding


class OnboardingFrag5 : Fragment() {
    var _binding: FragmentOnboardingFrag5Binding?=null
    val binding get() = _binding
    lateinit var con: Context;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.OnBoardingFrgementView,OnboardingFrag2())?.commitNow()
        _binding= FragmentOnboardingFrag5Binding.inflate(layoutInflater, container, false)
        binding?.fab?.setOnClickListener {
         var intent=Intent(con,LoginScreen::class.java)
            startActivity(intent)
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.OnBoardingFrgementView,OnboardingFrag5())?.commitNow()
        }
        return  binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        con=context
    }


}