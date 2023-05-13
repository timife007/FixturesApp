package com.timife.fixturesapp.data.local.model

import androidx.room.ColumnInfo

data class RegularTimeEntity(
    @ColumnInfo(name = "regular_away") val away: Int,
    @ColumnInfo(name = "regular_home") val home: Int
)