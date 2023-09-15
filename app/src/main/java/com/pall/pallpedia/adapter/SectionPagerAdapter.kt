package com.pall.pallpedia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pall.pallpedia.fragment.AboutDailyFragment
import com.pall.pallpedia.fragment.AboutDisasterFragment
import com.pall.pallpedia.fragment.AboutPoliticFragment
import com.pall.pallpedia.fragment.CommonFragment

// SectionPagerAdapter inheritance FragmentStateAdapter to override instance of adapter
// this is class will use for Fragment position in ViewPager2
class SectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    // getItemCount set mount of fragment which will be display in adapter
    override fun getItemCount() = 4
    override fun createFragment(position: Int): Fragment {
        // arrange of fragment position from left to right / 0 .. n
    return when (position) {
        0 -> CommonFragment()
        1 -> AboutDailyFragment()
        2 -> AboutDisasterFragment()
        3 -> AboutPoliticFragment()
        else -> CommonFragment()
    }
    }
}