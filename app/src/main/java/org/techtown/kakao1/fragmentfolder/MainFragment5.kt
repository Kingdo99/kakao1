package org.techtown.kakao1.fragmentfolder

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.kakao1.R
import org.techtown.kakao1.databinding.FragmentMain5Binding
import kotlin.concurrent.thread

class MainFragment5 : Fragment()
{

    val imageArray = arrayOf(
        R.drawable.ad0,
        R.drawable.ad1,
        R.drawable.ad2,
        R.drawable.ad3,
        R.drawable.ad4
    )

    private var mBinding: FragmentMain5Binding? = null
    private val binding get() = mBinding!!
    var i = 0
    var started = false
    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            binding.adviewRe.setImageResource(imageArray[i])

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        mBinding = FragmentMain5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.settingButton.setOnClickListener{
            val intent = Intent (activity, SettingActivity::class.java)
            activity?.startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("f_cycle","start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("f_cycle","resume")
        if (started == false) { // started 값이 false일 경우
            started = true // started 값 true로 변경

            thread(start = true) { // 스레드 생성
                while (started) { // started 값이true일 경우 반복
                    Thread.sleep(5000) // 5초 지연
                    if (i == 4)
                        i = 0
                    else
                        i++
                    if(started) { // started 값이 true일 경우
                        handler?.sendEmptyMessage(0) // Handler에 메세지 전달
                    }
                }
            }
        }
    }
    override fun onPause() {
        super.onPause()
        Log.d("f_cycle","pause")
        started=false
        Thread.interrupted()
    }

    override fun onStop() {
        super.onStop()
        Log.d("f_cycle","stop")
    }
}

