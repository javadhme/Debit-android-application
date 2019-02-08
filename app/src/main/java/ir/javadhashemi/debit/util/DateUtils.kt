package ir.javadhashemi.debit.util

import java.text.SimpleDateFormat
import java.util.*


object DateUtils {

    fun getDefaultDateFormat() = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT)


    //1 minute = 60 seconds
    //1 hour = 60 x 60 = 3600
    //1 day = 3600 x 24 = 86400
    fun computeDateDiff(startDate: String, endDate: String): LongArray {

        val firstDate = getDefaultDateFormat().parse(startDate)
        val secondDate = getDefaultDateFormat().parse(endDate)

        //milliseconds
        var different = secondDate.time - firstDate.time

        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24

        val elapsedDays = different / daysInMilli
        different %= daysInMilli

        val elapsedHours = different / hoursInMilli
        different %= hoursInMilli

        val elapsedMinutes = different / minutesInMilli
        different %= minutesInMilli

        val elapsedSeconds = different / secondsInMilli

        return longArrayOf(elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds)
    }


    fun getDayOfMonth(value: String): Int = getCalendar(value).get(Calendar.DAY_OF_MONTH)

    fun getMonth(value:String) : Int = getCalendar(value).get(Calendar.MONTH)

    fun getDayOfWeek(value: String): String {
        val day = getCalendar(value).get(Calendar.DAY_OF_WEEK)
        return when(day) {
            1 -> "شنبه"
            2 -> "یک شنبه"
            3 -> "دوشنبه"
            4 -> "سه شنبه"
            5 -> "چهارشنبه"
            6 -> "پنجشنبه"
            7 -> "جمعه"
            else -> ""
        }
    }

    private fun getCalendar(value: String) : Calendar =
            Calendar.getInstance().apply {
                time = getDefaultDateFormat().parse(value)
                firstDayOfWeek = Calendar.SATURDAY
            }


}