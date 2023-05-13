package com.timife.fixturesapp.domain.model

import com.timife.fixturesapp.data.remote.dtos.fixturesdto.FullTime
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.HalfTime
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.RegularTime

data class Scores(
    val fullTime: FullTime,
    val halfTime: HalfTime,
    val regularTime: RegularTime,
    val duration: String
)
