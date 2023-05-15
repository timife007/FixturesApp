package com.timife.fixturesapp.domain.model

import android.os.Parcelable
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.AwayTeam
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.HomeTeam
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fixture(
    val id: Int,
    val competitionId: Int,
    val competitionName: String,
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam,
    val score: Scores,
    val matchDate: String,
    val matchTime: String,
    val status: String,
    val matchday: Int
):Parcelable
