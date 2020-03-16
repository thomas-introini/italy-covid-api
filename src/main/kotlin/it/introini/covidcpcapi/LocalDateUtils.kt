package it.introini.covidcpcapi

import com.google.cloud.Timestamp
import java.time.LocalDate
import java.time.ZoneId

fun LocalDate.toGTimestamp(): Timestamp = Timestamp.ofTimeSecondsAndNanos(this.atStartOfDay(ZoneId.systemDefault()).toEpochSecond(), 0)