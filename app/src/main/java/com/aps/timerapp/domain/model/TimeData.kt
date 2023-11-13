package com.aps.timerapp.domain.model


data class TimeData(
    val hour: TimeUnit = TimeUnit(),
    val mins: TimeUnit = TimeUnit(),
    val sec: TimeUnit = TimeUnit()
) {
    fun isDataFul() = hour.leftDigit > 0

    fun isDataEmpty() =
        hour.leftDigit ==0 && hour.rightDigit == 0
                && mins.leftDigit == 0 && mins.rightDigit == 0
                && sec.leftDigit == 0 && sec.rightDigit == 0

    fun isHourHalfFull() = hour.leftDigit == 0 && hour.rightDigit > 0
}
