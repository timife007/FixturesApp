package com.timife.fixturesapp.domain.model

import com.timife.fixturesapp.data.remote.dtos.fixturesdto.AwayTeam
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.HomeTeam
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.Score

data class Fixture(
    val id: Int,
    val competitionId: Int,
    val competitionName: String,
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam,
    val score: Scores
)
