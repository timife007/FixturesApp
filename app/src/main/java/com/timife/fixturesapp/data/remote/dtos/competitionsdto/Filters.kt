package com.timife.fixturesapp.data.remote.dtos.competitionsdto


import com.squareup.moshi.Json

data class Filters(
    @field:Json(name = "client")
    val client: String
)