package com.busy.looping.pitaara.Fragments.OnboardingFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.FragmentOnboardingFrag1Binding


class OnboardingFrag1 : Fragment() {

    var _binding: FragmentOnboardingFrag1Binding?=null
    val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      _binding =FragmentOnboardingFrag1Binding.inflate(layoutInflater, container, false)
        binding?.getStartedBtn?.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.OnBoardingFrgementView,OnboardingFrag2())?.commitNow()
        }
        return binding?.root
    }


}