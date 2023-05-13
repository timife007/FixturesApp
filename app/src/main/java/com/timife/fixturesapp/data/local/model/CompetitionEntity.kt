package com.timife.fixturesapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "competition_entity")
data class CompetitionEntity(
    @PrimaryKey
    @ColumnInfo(name = "competition_id") val id:Int,
    val name:String,
    val emblem:String,
    val code:String
)
