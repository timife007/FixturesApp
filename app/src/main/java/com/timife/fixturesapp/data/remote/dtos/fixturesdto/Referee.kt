package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class Referee(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "nationality")
    val nationality: String?,
    @field:Json(name = "type")
    val type: String
)