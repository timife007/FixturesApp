package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class Season(
    @field:Json(name = "currentMatchday")
    val currentMatchday: Int,
    @field:Json(name = "endDate")
    val endDate: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "startDate")
    val startDate: String,
    @field:Json(name = "winner")
    val winner: Any?
)