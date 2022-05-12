package org.techtown.kakao1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.techtown.kakao1.databinding.FragmentMain3Binding

class MainFragment3 : Fragment()
{
    private var mBinding: FragmentMain3Binding? = null
    private val binding get() = mBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

        mBinding = FragmentMain3Binding.inflate(inflater, container, false)

        binding.viewpager.apply {
            adapter = MyPagerAdapter(context as FragmentActivity)
        }

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let{binding.viewpager.setCurrentItem(it, false)}
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = "Title $position"
//            when (position) {
////                0 -> tab.setIcon(R.drawable.ic_baseline_format_list_bulleted_24)
////                1 -> tab.setIcon(R.drawable.ic_baseline_map_24)
////                2 -> tab.setIcon(R.drawable.ic_baseline_info_24)
//            }
        }.attach()

        return binding.root

    }
}