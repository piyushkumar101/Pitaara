package com.busy.looping.pitaara.Fragments.OnboardingFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.FragmentOnboardingFrag3Binding
import com.busy.looping.pitaara.databinding.FragmentOnboardingFrag4Binding


class OnboardingFrag4 : Fragment() {

    var _binding: FragmentOnboardingFrag4Binding?=null
    val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding=FragmentOnboardingFrag4Binding.inflate(layoutInflater, container, false)
        binding?.fab?.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.OnBoardingFrgementView,OnboardingFrag5())?.commitNow()
        }
        return  binding?.root
    }


}
