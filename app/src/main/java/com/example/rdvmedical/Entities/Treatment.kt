package com.example.rdvmedical.Entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName="treatments")
data class Treatment (
    @PrimaryKey
    @NonNull
    var treatmentID:Long,
    val disease:String,
    val treatmentDescription:String,
    val treatmentBeginDate:Date,
    val treatmentEndDate:Date
)
