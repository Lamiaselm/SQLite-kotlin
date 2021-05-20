package com.example.rdvmedical.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="Doctors")
data class Doctor (
    @PrimaryKey
    val doctorID:String,
    val firstName:String,
    val lastName:Double,
    val speciality:String
)