package com.timife.fixturesapp.domain.model

import android.os.Parcelable
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.FullTime
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.HalfTime
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.RegularTime
import kotlinx.parcelize.Parcelize

@Parcelize
data class Scores(
    val fullTime: FullTime,
    val halfTime: HalfTime,
    val regularTime: RegularTime,
    val duration: String
):Parcelable
