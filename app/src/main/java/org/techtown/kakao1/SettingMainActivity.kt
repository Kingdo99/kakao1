package org.techtown.kakao1

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get

import org.techtown.kakao1.databinding.ActivitySettingmainBinding

class SettingMainActivity : AppCompatActivity() {
    private  var mBinding : ActivitySettingmainBinding? = null
    private  val binding get() = mBinding!!
    private var flag = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySettingmainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("cycle","onCreate")
        setFrag(0)

        flag = true

        binding.TabButton01.setOnClickListener {
            setFrag(1)
        }
        binding.TabButton02.setOnClickListener {
            setFrag(2)
        }
        binding.TabButton03.setOnClickListener {
            setFrag(3)
        }
        binding.TabButton04.setOnClickListener {
            setFrag(4)
        }
        binding.TabButton05.setOnClickListener {
            if (flag){
                finish()
            }else{
                setFrag(5)
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
