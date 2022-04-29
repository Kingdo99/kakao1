package org.techtown.kakao1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.techtown.kakao1.databinding.ActivityPlusFriendBinding
import java.lang.Exception

class PlusFriendActivity : AppCompatActivity() {

    private val databaseHelper: DatabaseHelper by lazy {
        DatabaseHelper.getInstance(applicationContext)
        //applicationcontext가 안먹어서 activity.applicationcontext
    }

    private  var mBinding : ActivityPlusFriendBinding? = null
    private  val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPlusFriendBinding.inflate(layoutInflater)
        setContentView(binding.root)
        insertDb()
        updateDb()
        deleteDb()
        getAlldb()
    }



    //데이터 베이스 조작이 이루어 졌을 때 textview의 처리를 위한 함수
//    private fun showTxt(text: String){
//        binding.tvResult.append(text + "\n")
//    }


    //crud조작이 이루어 졌을 때 edittext의 내용이 삭제 되도록 함수
    private fun clearEditTexts(){
        with(binding){
            etProfile.setText("")
            etName.setText("")
            etID.setText("")
        }
    }

    private fun insertDb(){
        var str = "R.drawable."
        str.plus(binding.etProfile.text.toString().trim())
        binding.btnInsert.setOnClickListener {
            try {
                databaseHelper.insertData(
                    str,
                    binding.etName.text.toString().trim()
                )
                clearEditTexts()
            }catch (e : Exception){
                e.printStackTrace()
            }
        }
    }

    private fun updateDb(){
        binding.btnUpdate.setOnClickListener {
            try {
                databaseHelper.updateData(
                    binding.etID.text.toString().trim(),
                    binding.etProfile.text.toString().trim(),
                    binding.etName.text.toString().trim()
                )
                clearEditTexts()
            }catch (e : Exception){

            }
        }
    }

    private fun deleteDb(){
        binding.btnDelete.setOnClickListener {
            try {
                databaseHelper.deleteData(binding.etID.text.toString().trim())
                clearEditTexts()
            } catch (e : Exception){
                e.printStackTrace()
            }
        }
    }

    private fun getAlldb(){
        try {
            val selectResult = databaseHelper.getAllDate()
        }catch (e :Exception){
            e.printStackTrace()
        }
    }






}