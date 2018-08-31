package com.example.sherryuan.greenthumb.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

/**
 * Created by sherryuan on 2018-08-29.
 */

@Database(entities = [(Plant::class)], version = 1)
@TypeConverters(Converters::class)
abstract class GreenThumbDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantDao

    companion object {
        private var INSTANCE: GreenThumbDatabase? = null
        private const val DB_NAME = "GREENTHUMB_DB"

        fun getDatabase(context: Context): GreenThumbDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<GreenThumbDatabase>(context.applicationContext, GreenThumbDatabase::class.java, DB_NAME)
                        .build()
            }
            return INSTANCE
        }
    }
}