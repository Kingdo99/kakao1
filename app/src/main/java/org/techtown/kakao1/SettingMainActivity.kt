package org.techtown.kakao1

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get

import org.techtown.kakao1.databinding.ActivitySettingmainBinding

class SettingMainActivity : AppCompatActivity() {
    private  var mBinding : ActivitySettingmainBinding? = null
    private  val binding get() = mBinding!!
    lateinit var tablist : List<ImageButton>
    var last : Int = 0
    private var flag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySettingmainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("cycle","onCreate")
        with(binding){
            tablist = listOf(TabButton0,TabButton1,TabButton2,TabButton3,TabButton4)
        }

        setFrag(0)
        FragImageChange(4)

        flag = true

        binding.TabButton0.setOnClickListener {
            setFrag(1)
            FragImageChange(0)
        }
        binding.TabButton1.setOnClickListener {
            setFrag(2)
            FragImageChange(1)
        }
        binding.TabButton2.setOnClickListener {
            setFrag(3)
            FragImageChange(2)
        }
        binding.TabButton3.setOnClickListener {
            setFrag(4)
            FragImageChange(3)
        }
        binding.TabButton4.setOnClickListener {
            if (flag){
                finish()
            }else{
                setFrag(5)
                FragImageChange(4)
                flag = true
            }
        }
    }
    private fun setFrag(Num : Int){

        val ft = supportFragmentManager.beginTransaction()
        ft.toString()
        when(Num){
            0->{ft.replace(R.id.frameLayout2,SettingActivity()).commit()
                flag = false
            }
            1->{ft.replace(R.id.frameLayout2,MainFragment1()).commit()
                flag = false
            }
            2->{ft.replace(R.id.frameLayout2,MainFragment2()).commit()
                flag = false
            }
            3->{ft.replace(R.id.frameLayout2,MainFragment3()).commit()
                flag = false
            }
            4->{ft.replace(R.id.frameLayout2,MainFragment4()).commit()
                flag = false
            }
            5->ft.replace(R.id.frameLayout2,SettingActivity()).commit()

        }


    }

    private fun FragImageChange(current : Int){
        //이전 tab unpush_image로 바꾸고
        //현재 tab push_image로 변경
        with(binding){
            tablist.get(last).setImageResource(resources.getIdentifier("unpush_"+(last),"drawable",packageName))
            tablist.get(current).setImageResource(resources.getIdentifier("push_"+(current),"drawable",packageName))
        }
        last = current
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
