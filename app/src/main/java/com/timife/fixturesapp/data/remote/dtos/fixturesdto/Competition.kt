package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class Competition(
    @field:Json(name = "code")
    val code: String,
    @field:Json(name = "emblem")
    val emblem: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "type")
    val type: String
)