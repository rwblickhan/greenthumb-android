package com.example.sherryuan.greenthumb.persistence

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * Created by sherryuan on 2018-08-29.
 */
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}