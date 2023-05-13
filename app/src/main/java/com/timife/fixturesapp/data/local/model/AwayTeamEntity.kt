package com.timife.fixturesapp.data.local.model

import androidx.room.ColumnInfo


data class AwayTeamEntity(
    @ColumnInfo(name = "away_id") val id:Int?,
    @ColumnInfo(name = "away_name") val name:String?,
    @ColumnInfo(name = "away_shortname") val shortName:String?,
    @ColumnInfo(name = "away_crest") val crest:String?,
    @ColumnInfo(name = "away_tla") val tla:String?
)