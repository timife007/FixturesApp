package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import com.squareup.moshi.Json

data class FixturesDto(
    @field:Json(name = "competition")
    val competition: Competition,
    @field:Json(name = "filters")
    val filters: Filters,
    @field:Json(name = "matches")
    val matches: List<Match>,
    @field:Json(name = "resultSet")
    val resultSet: ResultSet
)