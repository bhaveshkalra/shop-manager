package com.rttc.shopmanager.database

import androidx.room.TypeConverter
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    @TypeConverter
    fun fromTimestamp(value: String?): Date? {
        if (value != null) {
            try {
                val timeZone = TimeZone.getTimeZone("IST")
                dateFormat.timeZone = timeZone
                return dateFormat.parse(value)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return null
        } else {
            return null
        }
    }

    @TypeConverter
    fun dateToTimestamp(value: Date?): String? {
        val timeZone = TimeZone.getTimeZone("IST")
        dateFormat.timeZone = timeZone
        return if (value == null) null
        else dateFormat.format(value)
    }
}