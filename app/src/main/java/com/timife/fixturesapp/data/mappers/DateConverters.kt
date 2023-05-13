package com.timife.fixturesapp.data.mappers

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun convertUtcToLocalDate(utcDateString: String): String {
    val utcFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val localFormat = SimpleDateFormat("MMM dd", Locale.getDefault())

    utcFormat.timeZone = TimeZone.getTimeZone("UTC")
    localFormat.timeZone = TimeZone.getDefault()

    val utcDate = utcFormat.parse(utcDateString)

    return localFormat.format(utcDate)
}

fun convertUtcToLocalTime(utcDateTime: String): String {
    val utcFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val localFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    utcFormat.timeZone = TimeZone.getTimeZone("UTC")
    localFormat.timeZone = TimeZone.getDefault()

    val utcTime = utcFormat.parse(utcDateTime)

    return localFormat.format(utcTime)
}
