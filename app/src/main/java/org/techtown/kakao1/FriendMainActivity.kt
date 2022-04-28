package org.techtown.kakao1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.techtown.kakao1.databinding.ActivityFriendmainBinding
import org.techtown.kakao1.databinding.ActivitySettingmainBinding

class FriendMainActivity : AppCompatActivity() {
    private  var mBinding : ActivityFriendmainBinding? = null
    private  val binding get() = mBinding!!
    private var flag = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFriendmainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("cycle","onCreate")
        setFrag(0)

        flag = true
        binding.TabButton001.setOnClickListener {
            setFrag(1)
        }
        binding.TabButton002.setOnClickListener {
            setFrag(2)
        }
        binding.TabButton003.setOnClickListener {
            setFrag(3)
        }
        binding.TabButton004.setOnClickListener {
            setFrag(4)
        }
        binding.TabButton005.setOnClickListener {
            if (flag){
                this@FriendMainActivity.finishAffinity()
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
            0->{ft.replace(R.id.frameLayout3,FriendActivity()).commit()
                flag = false
            }
            1->{ft.replace(R.id.frameLayout3,MainFragment1()).commit()
                flag = false
            }
            2->{ft.replace(R.id.frameLayout3,MainFragment2()).commit()
                flag = false
            }
            3->{ft.replace(R.id.frameLayout3,MainFragment3()).commit()
                flag = false
            }
            4->{ft.replace(R.id.frameLayout3,MainFragment4()).commit()
                flag = false
            }
            5->ft.replace(R.id.frameLayout3,FriendActivity()).commit()
        }

    }
}
