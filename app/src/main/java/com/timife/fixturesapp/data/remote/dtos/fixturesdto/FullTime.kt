package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class FullTime(
    @field:Json(name = "away")
    val away: Int?,
    @field:Json(name = "home")
    val home: Int?
)