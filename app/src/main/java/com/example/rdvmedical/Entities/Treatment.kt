package com.example.rdvmedical.Entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName="treatments")
data class Treatment (
    @PrimaryKey
    @NonNull
    var treatmentID:Long,
    var doctorID:String,
    val disease:String,
    val tratmentDescription:String,
    val treatmentBeginDate:Date,
    val tratmentEndDate:Date
)
