package org.techtown.kakao1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.kakao1.databinding.FragmentMain1Binding
import java.util.ArrayList

class MainFragment1 : Fragment()
{
    //databasehelper를 전역변수로 선언

    lateinit var profileList : ArrayList<Profiles>
    private val databaseHelper: DatabaseHelper by lazy {
        DatabaseHelper.getInstance(activity?.applicationContext)
        //applicationcontext가 안먹어서 activity.applicationcontext
    }


    private var mBinding: FragmentMain1Binding? = null
    private val binding get() = mBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        mBinding = FragmentMain1Binding.inflate(inflater, container, false)

        //리사이클러 뷰에 연결 해줘야하는 layoutManager
        //현재 자기 자신의 모든 정보를 가져옴 this 하니간 안되네
        //일단 context

        binding.rvProfiles.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvProfiles.setHasFixedSize(true) // 리사클러 뷰에 대한 성능 개선 방안

        // adapter를 이제 리사이클러 뷰에 연결

        binding.plusFriendButton.setOnClickListener {
            val intent = Intent(activity, PlusFriendActivity::class.java)
            activity?.startActivity(intent)
        }

        return binding.root

    }

    override fun onStart() {

        //start 되었을 때 db에 저장되어있는 arraylist를 가져와서
        //adapater에 매개변수로 줘서 리사이클러 뷰에 연결

        Log.d("db","start, getarrayList")
        profileList = databaseHelper.getarrayList()
        binding.rvProfiles.adapter = ProfileAdapter(profileList)
        super.onStart()

    }
}