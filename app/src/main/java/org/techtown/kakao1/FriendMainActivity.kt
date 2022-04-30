package org.techtown.kakao1

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import org.techtown.kakao1.databinding.ActivityFriendmainBinding
import org.techtown.kakao1.databinding.ActivitySettingmainBinding

class FriendMainActivity : AppCompatActivity() {
    private  var mBinding : ActivityFriendmainBinding? = null
    private  val binding get() = mBinding!!
    lateinit var tablist : List<ImageButton>
    var last : Int = 0
    private var flag = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFriendmainBinding.inflate(layoutInflater)
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
                this@FriendMainActivity.finishAffinity()
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

    private fun FragImageChange(current : Int){
        with(binding){
            tablist.get(last).setImageResource(resources.getIdentifier("unpush_"+(last),"drawable",packageName))
            tablist.get(current).setImageResource(resources.getIdentifier("push_"+(current),"drawable",packageName))
        }
        last = current
    }
}
