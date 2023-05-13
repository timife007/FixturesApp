package com.timife.fixturesapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fixture_entity")
data class FixtureEntity(
    @PrimaryKey
    @ColumnInfo(name = "fixture_id") val id: Int,
    val competitionId: Int,
    val competitionName: String,
    @Embedded val homeTeam: HomeTeamEntity,
    @Embedded val awayTeam: AwayTeamEntity,
    @Embedded val score: ScoreEntity
)
