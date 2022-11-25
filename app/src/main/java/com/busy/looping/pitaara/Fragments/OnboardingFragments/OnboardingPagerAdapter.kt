package com.busy.looping.pitaara.Fragments.OnboardingFragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.busy.looping.pitaara.R

class OnboardingPagerAdapter(fm : FragmentManager)  :FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        var bundle = Bundle()
        when(position) {
            0 -> {
                return OnboardingFrag1.newInstance(Bundle())
            }
            1 -> {
                bundle.putString(OnboardingFrag2.Keys.imgRes, "")
            }
            2 -> {
                bundle.putString("", "")
            }
            3 -> {
                bundle.putString("", "")
            }
        }
        return OnboardingFrag1.newInstance(Bundle())
    }
}