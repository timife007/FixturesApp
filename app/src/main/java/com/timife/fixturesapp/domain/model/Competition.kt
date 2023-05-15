package com.timife.fixturesapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Competition(
    val id: Int,
    val name: String,
    val emblem: String,
    val code: String,
) : Parcelable
