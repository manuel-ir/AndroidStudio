package com.pf.turismoandalucia.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places_table")
data class Place(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val province: String,
    val description: String
)