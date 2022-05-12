package org.techtown.kakao1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    private val NUM_PAGES = 5

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { BlankFragment.newInstance("MyView","")}
            1 -> { BlankFragment.newInstance("발견","")}
            else -> { BlankFragment.newInstance("카카오TV","")}
        }
    }
}