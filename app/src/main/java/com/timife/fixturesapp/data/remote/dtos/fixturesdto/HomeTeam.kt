package com.timife.fixturesapp.data.remote.dtos.fixturesdto


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeTeam(
    @field:Json(name = "crest")
    val crest: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "shortName")
    val shortName: String?,
    @field:Json(name = "tla")
    val tla: String?
):Parcelable