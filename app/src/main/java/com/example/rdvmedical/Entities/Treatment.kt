package com.example.rdvmedical.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName="treatments")
data class Treatment (
    @PrimaryKey
    val treatmentID:Long,
    val disease:String,
    val tratmentDescription:String,
    val treatmentBeginDate:Date,
    val tratmentEndDate:Date
)