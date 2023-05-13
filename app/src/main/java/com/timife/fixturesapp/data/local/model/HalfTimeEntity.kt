package com.timife.fixturesapp.data.local.model

import androidx.room.ColumnInfo

data class HalfTimeEntity(
    @ColumnInfo(name = "half_away") val away: Int?,
    @ColumnInfo(name = "half_home") val home: Int?
)