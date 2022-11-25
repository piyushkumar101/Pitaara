package com.busy.looping.pitaara.Fragments.OnboardingFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.busy.looping.pitaara.R


class OnboardingFrag2 : Fragment() {
    private var bundle: Bundle? = null

    class Keys {
        companion object {
            const val imgRes = "GenOnboardingFragImgRes"
        }
    }

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
        return inflater.inflate(R.layout.fragment_onboarding_frag1, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(bundle: Bundle) =
            OnboardingFrag2().apply {
                arguments = bundle
            }
    }
}