package org.techtown.kakao1

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import org.techtown.kakao1.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private  var mBinding : ActivityMainBinding? = null
    private  val binding get() = mBinding!!
    lateinit var tablist : List<ImageButton>
    var last : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("cycle","onCreate")

        with(binding){
            tablist = listOf(TabButton0,TabButton1,TabButton2,TabButton3,TabButton4)
        }

        setFrag(1)
        FragImageChange(0)


        with(binding) {
            TabButton0.setOnClickListener {
                setFrag(1)
                FragImageChange(0)
            }
           TabButton1.setOnClickListener {
                setFrag(2)
               FragImageChange(1)
            }
            TabButton2.setOnClickListener {
                setFrag(3)
                FragImageChange(2)
            }
            TabButton3.setOnClickListener {
                setFrag(4)
                FragImageChange(3)
            }
            TabButton4.setOnClickListener {
                setFrag(5)
                FragImageChange(4)
            }
        }



    }

    private fun setFrag(Num : Int){

        val ft = supportFragmentManager.beginTransaction()

        when(Num){
            1->ft.replace(R.id.frameLayout,MainFragment1()).commit()
            2->ft.replace(R.id.frameLayout,MainFragment2()).commit()
            3->ft.replace(R.id.frameLayout,MainFragment3()).commit()
            4->ft.replace(R.id.frameLayout,MainFragment4()).commit()
            5->ft.replace(R.id.frameLayout,MainFragment5()).commit()
        }


    }

    private fun FragImageChange(current : Int){
        with(binding){
            tablist.get(last).setImageResource(resources.getIdentifier("unpush_"+(last),"drawable",packageName))
            tablist.get(current).setImageResource(resources.getIdentifier("push_"+(current),"drawable",packageName))
        }
        last = current
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


