package at.sunilson.ktx.datetime

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

fun Long.toZonedDateTime(): ZonedDateTime = Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault())
