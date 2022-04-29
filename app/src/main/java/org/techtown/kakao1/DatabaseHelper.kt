package org.techtown.kakao1

class DatabaseHelper {
    //key를 companion object에 정의
    //데이터베이스 구조를 정의
    companion object{
        const val DATABASE_NAME = "ProfileBook.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "profile_table"
        const val COL1_ID = "_id"
        const val COL2_NAME = "name"
        const val COL3_PHONE = "phone"
        const val COL4_EMAIL = "email"
    }
}