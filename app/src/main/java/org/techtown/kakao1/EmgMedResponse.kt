package org.techtown.kakao1


import com.squareup.moshi.Json

data class EmgMedResponse(
    @field:Json(name = "caseCount")
    val caseCount: Int?,
    @field:Json(name = "casePercentage")
    val casePercentage: Int?,
    @field:Json(name = "checkingCounter")
    val checkingCounter: Int?,
    @field:Json(name = "checkingPercentage")
    val checkingPercentage: Int?,
    @field:Json(name = "city1n")
    val city1n: String?,
    @field:Json(name = "city1p")
    val city1p: String?,
    @field:Json(name = "city2n")
    val city2n: String?,
    @field:Json(name = "city2p")
    val city2p: String?,
    @field:Json(name = "city3n")
    val city3n: String?,
    @field:Json(name = "city3p")
    val city3p: String?,
    @field:Json(name = "city4n")
    val city4n: String?,
    @field:Json(name = "city4p")
    val city4p: String?,
    @field:Json(name = "city5n")
    val city5n: String?,
    @field:Json(name = "city5p")
    val city5p: String?,
    @field:Json(name = "deathPercentage")
    val deathPercentage: Double?,
    @field:Json(name = "notcaseCount")
    val notcaseCount: Int?,
    @field:Json(name = "notcasePercentage")
    val notcasePercentage: Int?,
    @field:Json(name = "NowCase")
    val nowCase: String?,
    @field:Json(name = "recoveredPercentage")
    val recoveredPercentage: Int?,
    @field:Json(name = "resultCode")
    val resultCode: String?,
    @field:Json(name = "resultMessage")
    val resultMessage: String?,
    @field:Json(name = "source")
    val source: String?,
    @field:Json(name = "TodayDeath")
    val todayDeath: Int?,
    @field:Json(name = "TodayRecovered")
    val todayRecovered: Int?,
    @field:Json(name = "TotalCase")
    val totalCase: String?,
    @field:Json(name = "TotalCaseBefore")
    val totalCaseBefore: String?,
    @field:Json(name = "TotalChecking")
    val totalChecking: Int?,
    @field:Json(name = "TotalDeath")
    val totalDeath: String?,
    @field:Json(name = "TotalRecovered")
    val totalRecovered: String?,
    @field:Json(name = "updateTime")
    val updateTime: String?
)