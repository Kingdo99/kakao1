package org.techtown.kakao1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception
import java.lang.reflect.Field
import java.util.*

// sqliteopenhelper를 상속받는 클래스임
class DatabaseHelper private constructor(context: Context?) :
SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    // construct에 직접 접근하지못하게, 즉 생성자를 호출하지 못하게 private로 선언
    // -> getInstance에서 doublecheckedlocking을 통해서 instance를 반환하는 싱글톤 구조를 남김


   //key를 companion object에 정의
    //데이터베이스 구조를 정의
    companion object{
        const val DATABASE_NAME = "ProfileBook.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "profile_table"
        const val COL1_ID = "_id"
        const val COL2_PI = "profile_image"
        const val COL3_NAME = "name"

       //SQLITEOPENHELPER의 객체가 여러개 생기게 되면 여러 개 인스턴스가
       //같은 디비에 동시에 접근하면 문제가 발생 할 수 있음 -> 그래서 DATABASE를 SINGLETON으로 생성

       @Volatile
       private var instance : DatabaseHelper? = null

       fun getInstance(context: Context?) =
           instance ?: synchronized(DatabaseHelper::class.java){
               instance ?: DatabaseHelper(context).also {
                   instance = it
               }
           }
   }

    // SQLiteOpenHelper 멤버들을 오버라이딩 해줘야함
    override fun onCreate(p0: SQLiteDatabase?) {
        // 시스템에 데이터베이스 파일이 없을 때 단 한번만 실행 되는 함수
        // 쿼리 정의 ID는 PRIMARY,기본 키 이므로 INTEGER PRIMARY KEY AUTO INCREMENT를 통해 자동 증가 구현
        val createQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COL1_ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "$COL2_PI TEXT, " +
                "$COL3_NAME TEXT" +
                ")"
        p0?.execSQL(createQuery)
        // 쿼리문 해당 디비에 실행 p0은 db
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        //db 버전이 변경되었을 때 동작하는 함수, p1은 oldVersion, p2는 newVersion
        if (p1!=p2){
            p0?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            // 만약 존재한다면 삭제
            onCreate(p0)
            //삭제하고 다시 생성
        }
    }

    //crud 구현
    fun insertData(image_route : Int,name : String){
        val db = this.writableDatabase
        //writableDatabase로 db오픈
        val contentValues = ContentValues().apply {
            put(COL2_PI,image_route)
            put(COL3_NAME,name)
            //매개변수로 받은 데이터를 ContentValues로 묶어서
            //insert명령어로 db에 데이터 추가
        }
        db.insert(TABLE_NAME, null, contentValues)
        //데이터를 추가할 테이블 이름과 데이터 묶음인 contentValues를 매개변수
    }

    fun updateData(id: String, image_route: String, name : String){
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COL1_ID,id)
            put(COL2_PI,image_route)
            put(COL3_NAME,name)
        }
        db.update(TABLE_NAME,contentValues,"$COL1_ID = ?", arrayOf(id))
        //id로 선택한 데이터를 갱신해줌 id값이 primary,기본키 이므로 기본키로 비교
        //COL_ID = ? 로 갱신할 데이터를 특정해줌
    }

    fun deleteData(id : String){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,"$COL1_ID = ?", arrayOf(id))
        //id 값으로 특정 데이터를 db에서 삭제
    }

    fun deleteAll(){
        val db = this.writableDatabase
        db.execSQL("delete from $TABLE_NAME")
    }

    fun getAllDate() : String{
        var result = "No data in DB"

        val db = this.readableDatabase
        //자료를 읽을 것이기 때문에 readableDatabase로 db를 열고
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        //rawQuery에 해당 테이블네임의 테이블에 있는 모든 정보를 커서에 담음
        try {
             if (cursor.count != 0){
                 //해당 커서에 정보가 있다면
                val stringBuffer = StringBuffer()
             while (cursor.moveToNext()){
                 // moveToNext()로 해당 커서에 담긴 정보를 순회하며 모두 탐색
                stringBuffer.append("ID :" + cursor.getInt(0).toString() + "\n")
                stringBuffer.append("PI :" + cursor.getString(1) + "\n")
                stringBuffer.append("NAME :" + cursor.getString(2)+ "\n\n")
                                         }
            result = stringBuffer.toString()
                 //받아온 값을 stringbuffer에 저장하고 result string 변수에 전달
                    }
            }catch (e:Exception){
                    e.printStackTrace()
            }finally {
                if (cursor != null && !cursor.isClosed){
                cursor.close()
                    //cursor를 다 사용하면 결과적으로 cursor 객체의 리소스를 반환
                }
            }
        return result
    }

    fun getarrayList() : ArrayList<Profiles>{
        val result = arrayListOf<Profiles>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        var a : Int
        var b : String
        var bus : Profiles
        try {
            if (cursor.count != 0){
                //해당 커서에 정보가 있다면
                val stringBuffer = StringBuffer()
                while (cursor.moveToNext()){
                    // moveToNext()로 해당 커서에 담긴 정보를 순회하며 모두 탐색
                    a = cursor.getInt(1)//iamge
                    b = cursor.getString(2)//profileimage
                    Log.d("db11",R.drawable.profile_image.toString())
                    Log.d("db15","${a}")
                     if(a==0){
                        // 이미지를 설정 안했다면 기본이미지 나오게
                      bus =Profiles(R.drawable.profile_image,b)
                         Log.d("db1","3")
                    }else{
                        //여기서 String 타입으로 R.drawable.~ 이런식으로 주면 안먹음
                        //R.~~ 무슨 개념이 먹어서 안되는 듯 그래서 애초에 리소스id로 주기로 결정
                        // 이미지의 리소스id를 가져오는 getresources()는 액티비티에서만 됨 그래서
                        // insert를 호출하는 activity에서 값을 줄 때 부터 resid로 변환 시켜서 주기로 결정, PlusFrinedActivity에서 진행

                      bus = Profiles(a,b)
                         Log.d("db12","4")
                    }
                    result.add(bus)
                }

            }
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            if (cursor != null && !cursor.isClosed){
                cursor.close()
                //cursor를 다 사용하면 결과적으로 cursor 객체의 리소스를 반환
            }
        }
        return result
    }
}