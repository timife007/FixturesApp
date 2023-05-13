package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class Score(
    @field:Json(name = "duration")
    val duration: String,
    @field:Json(name = "extraTime")
    val extraTime: ExtraTime?,
    @field:Json(name = "fullTime")
    val fullTime: FullTime,
    @field:Json(name = "halfTime")
    val halfTime: HalfTime,
    @field:Json(name = "penalties")
    val penalties: Penalties?,
    @field:Json(name = "regularTime")
    val regularTime: RegularTime?,
    @field:Json(name = "winner")
    val winner: String?
)