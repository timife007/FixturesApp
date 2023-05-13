package com.timife.fixturesapp.data.remote.dtos.competitionsdto


import com.squareup.moshi.Json

data class CompetitionDto(
    @field:Json(name = "area")
    val area: Area,
    @field:Json(name = "code")
    val code: String,
    @field:Json(name = "currentSeason")
    val currentSeason: CurrentSeason,
    @field:Json(name = "emblem")
    val emblem: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "lastUpdated")
    val lastUpdated: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "numberOfAvailableSeasons")
    val numberOfAvailableSeasons: Int,
    @field:Json(name = "plan")
    val plan: String,
    @field:Json(name = "type")
    val type: String
)