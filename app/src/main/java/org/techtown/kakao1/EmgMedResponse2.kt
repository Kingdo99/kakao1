package org.techtown.kakao1


import com.squareup.moshi.Json

data class EmgMedResponse2(
    @field:Json(name = "korea")
    val korea: Korea?
)
data class Korea(
    @field:Json(name = "countryNm")
    val countryNm: String?,
    @field:Json(name = "vaccine_1")
    val vaccine1: Vaccine1?,
    @field:Json(name = "vaccine_2")
    val vaccine2: Vaccine2?,
    @field:Json(name = "vaccine_3")
    val vaccine3: Vaccine3?
)

data class Vaccine1(
    @field:Json(name = "vaccine_1")
    val vaccine1: Int?,
    @field:Json(name = "vaccine_1_new")
    val vaccine1New: Int?,
    @field:Json(name = "vaccine_1_old")
    val vaccine1Old: Int?
)

data class Vaccine2(
    @field:Json(name = "vaccine_2")
    val vaccine2: Int?,
    @field:Json(name = "vaccine_2_new")
    val vaccine2New: Int?,
    @field:Json(name = "vaccine_2_old")
    val vaccine2Old: Int?
)

data class Vaccine3(
    @field:Json(name = "vaccine_3")
    val vaccine3: Int?,
    @field:Json(name = "vaccine_3_new")
    val vaccine3New: Int?,
    @field:Json(name = "vaccine_3_old")
    val vaccine3Old: Int?
)
