package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class ResultSet(
    @field:Json(name = "count")
    val count: Int,
    @field:Json(name = "first")
    val first: String,
    @field:Json(name = "last")
    val last: String,
    @field:Json(name = "played")
    val played: Int
)