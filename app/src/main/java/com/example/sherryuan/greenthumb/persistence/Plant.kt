package com.example.sherryuan.greenthumb.persistence

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by sherryuan on 2018-08-29.
 */
@Entity(tableName = "Plants")
data class Plant(
        @PrimaryKey
        var id: Int = 0,
        var imageUri: String = "",
        var name: String = "",
        var description: String = "",
        var daysBetweenWatering: Int = 0,
        var lastWatered: Date
)