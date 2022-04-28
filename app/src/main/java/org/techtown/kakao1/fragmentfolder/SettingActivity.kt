package org.techtown.kakao1.fragmentfolder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.techtown.kakao1.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.friendIntentLayout.setOnClickListener {
            val intent = Intent (this, FriendActivity::class.java)
            startActivity(intent)

        }
    }
}