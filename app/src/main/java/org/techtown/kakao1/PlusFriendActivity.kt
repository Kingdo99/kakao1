package org.techtown.kakao1

import android.graphics.drawable.Drawable
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

        binding.btnInsert.setOnClickListener {
            try {
                //해당 이미지의 리소스id를 가져오는 getresources()->resources는 activity에서만 가능
                // 변수 str 에 사용자가 입력한 프로필 이미지 이름을 trim해서 text형식으로가짐
                // Resources 인스턴스에 getIdentifier() 실행 해당 1. 이미지 이름, 2. 이미지 type, 3. 패키지네임
                val str = binding.etProfile.text.toString().trim()
                databaseHelper.insertData(

                    resources.getIdentifier(str,"drawable",packageName),
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