package org.techtown.kakao1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.kakao1.R
import org.techtown.kakao1.databinding.FragmentMain1Binding
import org.techtown.kakao1.databinding.FragmentMain5Binding

class MainFragment1 : Fragment()
{
    private var mBinding: FragmentMain1Binding? = null
    private val binding get() = mBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        mBinding = FragmentMain1Binding.inflate(inflater, container, false)

        val profileList = arrayListOf(
            Profiles(R.drawable.profile_image,"김도우0"),
            Profiles(R.drawable.profile_image,"김도우1"),
            Profiles(R.drawable.profile_image,"김도우2"),
            Profiles(R.drawable.profile_image,"김도우3"),
            Profiles(R.drawable.profile_image,"김도우4"),
            Profiles(R.drawable.profile_image,"김도우5"),
            Profiles(R.drawable.profile_image,"김도우6"),
            Profiles(R.drawable.profile_image,"김도우7"),
            Profiles(R.drawable.profile_image,"김도우8"),
            Profiles(R.drawable.profile_image,"김도우9"),
            Profiles(R.drawable.profile_image,"김도우10"),
            Profiles(R.drawable.profile_image,"김도우11"),
        )

        //리사이클러 뷰에 연결 해줘야하는 layoutManager
        //현재 자기 자신의 모든 정보를 가져옴 this 하니간 안되네
        //일단 context
        binding.rvProfiles.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvProfiles.setHasFixedSize(true) // 리사클러 뷰에 대한 성능 개선 방안

        // adapter를 이제 리사이클러 뷰에 연결
        binding.rvProfiles.adapter = ProfileAdapter(profileList)

        return binding.root

    }
}