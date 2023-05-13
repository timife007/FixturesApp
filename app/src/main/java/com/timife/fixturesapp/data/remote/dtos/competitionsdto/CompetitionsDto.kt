package com.timife.fixturesapp.data.remote.dtos.competitionsdto


import com.squareup.moshi.Json

data class CompetitionsDto(
    @field:Json(name = "competitions")
    val competitions: List<CompetitionDto>,
    @field:Json(name = "count")
    val count: Int,
    @field:Json(name = "filters")
    val filters: Filters
)