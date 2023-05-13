package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class Match(
    @field:Json(name = "area")
    val area: Area,
    @field:Json(name = "awayTeam")
    val awayTeam: AwayTeam,
    @field:Json(name = "competition")
    val competition: Competition,
    @field:Json(name = "group")
    val group: String?,
    @field:Json(name = "homeTeam")
    val homeTeam: HomeTeam,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "lastUpdated")
    val lastUpdated: String,
    @field:Json(name = "matchday")
    val matchday: Int?,
    @field:Json(name = "odds")
    val odds: Odds,
    @field:Json(name = "referees")
    val referees: List<Referee>,
    @field:Json(name = "score")
    val score: Score,
    @field:Json(name = "season")
    val season: Season,
    @field:Json(name = "stage")
    val stage: String,
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "utcDate")
    val utcDate: String
)