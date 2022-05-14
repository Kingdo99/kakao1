package org.techtown.kakao1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.kakao1.databinding.ActivityFriendBinding


class FriendActivity : Fragment(){
    private var mBinding: ActivityFriendBinding? = null
    private val binding get() = mBinding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = ActivityFriendBinding.inflate(inflater, container, false)
        return binding.root
    }
}