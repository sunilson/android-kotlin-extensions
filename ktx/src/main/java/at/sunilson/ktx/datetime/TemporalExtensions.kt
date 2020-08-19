package at.sunilson.ktx.datetime

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor

@RequiresApi(Build.VERSION_CODES.O)
fun TemporalAccessor.formatFull() = DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm").format(this)

@RequiresApi(Build.VERSION_CODES.O)
fun TemporalAccessor.formatPattern(pattern: String) = DateTimeFormatter.ofPattern(pattern).format(this)