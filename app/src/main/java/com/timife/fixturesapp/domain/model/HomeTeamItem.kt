package com.timife.fixturesapp.domain.model

import com.squareup.moshi.Json

data class HomeTeamItem(
    val crest: String,
    val id: Int,
    val name: String,
    val shortName: String,
    val tla: String
)