package com.example.rdvmedical.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="doctors")
data class Doctor (

    var firstName:String,
    var lastName:Double,
    var speciality:String
)
{
    @PrimaryKey(autoGenerate = true)
    var doctorID:String?=null
}