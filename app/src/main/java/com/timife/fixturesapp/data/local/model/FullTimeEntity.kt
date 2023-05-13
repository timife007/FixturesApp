package com.timife.fixturesapp.data.local.model

import androidx.room.ColumnInfo
import com.squareup.moshi.Json

data class FullTimeEntity(
    @ColumnInfo(name = "full_away")val away: Int?,
    @ColumnInfo(name = "full_home") val home: Int?
)