package at.sunilson.ktx.datetime

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@RequiresApi(Build.VERSION_CODES.O)
fun Long.toZonedDateTime(): ZonedDateTime =
    Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault())

@RequiresApi(Build.VERSION_CODES.O)
fun Instant.toZonedDateTime() = ZonedDateTime.from(this).withZoneSameInstant(ZoneId.systemDefault())
