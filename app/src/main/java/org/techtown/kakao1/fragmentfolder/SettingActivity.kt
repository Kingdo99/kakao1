package org.techtown.kakao1.fragmentfolder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.techtown.kakao1.R
import org.techtown.kakao1.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFrag(5)

        binding.friendIntentLayout.setOnClickListener {
            val intent = Intent (this, FriendActivity::class.java)
            startActivity(intent)
        }



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

    private  fun setFrag(Num : Int) {

        val ft = supportFragmentManager.beginTransaction()

        when (Num) {
            1 -> ft.replace(R.id.frameLayout2, MainFragment1()).commit()
            2 -> ft.replace(R.id.frameLayout2, MainFragment2()).commit()
            3 -> ft.replace(R.id.frameLayout2, MainFragment3()).commit()
            4 -> ft.replace(R.id.frameLayout2, MainFragment4()).commit()
            5 -> ft.replace(R.id.frameLayout2, MainFragment5()).commit()
        }
    }
}