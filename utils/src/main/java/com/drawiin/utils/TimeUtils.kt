package com.drawiin.utils

object TimeUtils {
    private const val ONE_SECOND_IN_MILLISECONDS = 1000L
    private const val ONE_MINUTE_IN_SECONDS = 60

    fun minutesToSeconds(minutes: Long) = minutes * ONE_MINUTE_IN_SECONDS

    fun secondsToMilliseconds(seconds: Long) = seconds * ONE_SECOND_IN_MILLISECONDS

    fun millisecondsToSeconds(milliseconds: Long) =  milliseconds / ONE_SECOND_IN_MILLISECONDS
}
