package com.timife.fixturesapp.data.local.model

import androidx.room.Embedded
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.FullTime
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.HalfTime
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.RegularTime

data class ScoreEntity(
    @Embedded  val fullTime:FullTimeEntity?,
    @Embedded val halfTime: HalfTimeEntity?,
    @Embedded val regularTime: RegularTimeEntity?,
    val duration:String
)
