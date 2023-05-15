package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegularTime(
    @field:Json(name = "away")
    val away: Int?,
    @field:Json(name = "home")
    val home: Int?
):Parcelable