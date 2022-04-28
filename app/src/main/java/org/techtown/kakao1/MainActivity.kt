package org.techtown.kakao1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.techtown.kakao1.databinding.ActivityMainBinding
import org.techtown.kakao1.fragmentfolder.*


class MainActivity : AppCompatActivity() {


//hi

    private  var mBinding : ActivityMainBinding? = null
    private  val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("cycle","onCreate")

        val list = listOf(MainFragment1(),MainFragment2(), MainFragment3(), MainFragment4(), MainFragment5()
        )
        val pagerAdapter = FragmentPagerAdapter(list, this)
        binding.viewpager.adapter = pagerAdapter


        TabLayoutMediator(binding.tabLayout,binding.viewpager) { tab, position ->

            when (position) {
                0 -> tab.setIcon(R.drawable.person_icon)
                1 -> tab.setIcon(R.drawable.chatting)
                2 -> tab.setIcon(R.drawable.news)
                3 -> tab.setIcon(R.drawable.shopping)
                4 -> tab.setIcon(R.drawable.moreview)
            }

            binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabReselected(p0: TabLayout.Tab?) {}
                override fun onTabUnselected(p0: TabLayout.Tab?) {
                    when (p0?.position) {
                        0 -> p0.setIcon(R.drawable.person_icon)
                        1 -> p0.setIcon(R.drawable.chatting_icon)
                        2 -> p0.setIcon(R.drawable.news_icon)
                        3 -> p0.setIcon(R.drawable.shopping_icon)
                        4 -> p0.setIcon(R.drawable.more_icon)
                    }
                }
                override fun onTabSelected(p0: TabLayout.Tab?) {
                    when (p0?.position) {
                        0 -> p0.setIcon(R.drawable.person2_icon)
                        1 -> p0.setIcon(R.drawable.chatting_icon)
                        2 -> p0.setIcon(R.drawable.news_icon)
                        3 -> p0.setIcon(R.drawable.shopping_icon)
                        4 -> p0.setIcon(R.drawable.more_icon)
                    }

                }
            })



        }.attach()



    }

    override fun onStart() {
        super.onStart()
        Log.d("cycle","onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("cycle","onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("cycle","onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("cycle","onStop")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("cycle","onRestart")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("cycle","onDestroy")

    }
}




class FragmentPagerAdapter(val fragmentList:List<Fragment>,fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = fragmentList.get(position)




}