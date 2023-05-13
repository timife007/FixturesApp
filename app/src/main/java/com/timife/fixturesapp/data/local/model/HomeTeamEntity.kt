package com.timife.fixturesapp.data.local.model

import androidx.room.ColumnInfo
import kotlinx.serialization.Serializable


data class HomeTeamEntity(
    @ColumnInfo(name = "home_id") val id:Int?,
    @ColumnInfo(name = "home_name") val name:String?,
    @ColumnInfo(name = "home_shortname") val shortName:String?,
    @ColumnInfo(name = "home_crest") val crest:String?,
    @ColumnInfo(name = "home_tla") val tla:String?
)
