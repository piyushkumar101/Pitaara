package com.busy.looping.pitaara.Fragments.OnboardingFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.busy.looping.pitaara.R
import com.busy.looping.pitaara.databinding.FragmentOnboardingFrag1Binding
import com.busy.looping.pitaara.databinding.FragmentOnboardingFrag2Binding


class OnboardingFrag2 : Fragment() {
    private var bundle: Bundle? = null

    var _binding: FragmentOnboardingFrag2Binding?=null
    val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bundle = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding= FragmentOnboardingFrag2Binding.inflate(layoutInflater, container, false)

        binding?.fab?.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.OnBoardingFrgementView,OnboardingFrag3())?.commitNow()
        }
        return binding?.root
    }


}