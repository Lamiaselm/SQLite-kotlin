package com.example.rdvmedical.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName="treatments")
data class Treatment (

    val disease:String,
    val tratmentDescription:String,
    val treatmentBeginDate:Date,
    val tratmentEndDate:Date
)
{

    @PrimaryKey(autoGenerate = true)
    var treatmentID:Long?=null
}