package com.example.rdvmedical.Entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName="treatments",foreignKeys =
arrayOf(
    ForeignKey(entity = Doctor::class,
        parentColumns = arrayOf("doctorD"),
        childColumns = arrayOf("doctorID"),
        onDelete = ForeignKey.CASCADE)

))
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
