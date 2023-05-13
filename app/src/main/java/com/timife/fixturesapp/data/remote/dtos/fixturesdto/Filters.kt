package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class Filters(
    @field:Json(name = "season")
    val season: String
)