package org.techtown.kakao1
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import org.techtown.kakao1.databinding.ActivitySettingBinding
import org.techtown.kakao1.databinding.FragmentMain5Binding
import java.util.zip.Inflater


class SettingActivity : Fragment(){


    private var mBinding: ActivitySettingBinding? = null
    private val binding get() = mBinding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = ActivitySettingBinding.inflate(inflater, container, false)
        binding.friendIntentLayout.setOnClickListener {
            val intent = Intent(activity, FriendMainActivity::class.java)
            activity?.startActivity(intent)
        }
        return binding.root
    }


}
