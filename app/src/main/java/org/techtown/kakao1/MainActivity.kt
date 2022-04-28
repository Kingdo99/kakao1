package org.techtown.kakao1

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.techtown.kakao1.databinding.ActivityMainBinding
import org.techtown.kakao1.fragmentfolder.*


class MainActivity : AppCompatActivity() {




    private  var mBinding : ActivityMainBinding? = null
    private  val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("cycle","onCreate")

        setFrag(1)

        binding.TabButton1.setOnClickListener {
            setFrag(1)
        }
        binding.TabButton2.setOnClickListener {
            setFrag(2)
        }
        binding.TabButton3.setOnClickListener {
            setFrag(3)
        }
        binding.TabButton4.setOnClickListener {
            setFrag(4)
        }
        binding.TabButton5.setOnClickListener {
            setFrag(5)
        }




    }

    private fun setFrag(Num : Int){

        val ft = supportFragmentManager.beginTransaction()

        when(Num){
            1->ft.replace(R.id.frameLayout,MainFragment1()).commit()
            2->ft.replace(R.id.frameLayout,MainFragment2()).commit()
            3->ft.replace(R.id.frameLayout,MainFragment3()).commit()
            4->ft.replace(R.id.frameLayout,MainFragment4()).commit()
            5->ft.replace(R.id.frameLayout,MainFragment5()).commit()
        }


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