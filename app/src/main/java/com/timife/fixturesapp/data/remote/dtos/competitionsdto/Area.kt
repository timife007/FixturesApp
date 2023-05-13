package com.timife.fixturesapp.data.remote.dtos.competitionsdto


import com.squareup.moshi.Json

data class Area(
    @field:Json(name = "code")
    val code: String,
    @field:Json(name = "flag")
    val flag: String?,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String
)