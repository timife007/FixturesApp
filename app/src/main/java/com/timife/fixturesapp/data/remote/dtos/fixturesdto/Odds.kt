package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class Odds(
    @field:Json(name = "msg")
    val msg: String
)