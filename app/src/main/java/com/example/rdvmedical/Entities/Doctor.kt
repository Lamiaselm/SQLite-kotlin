package com.example.rdvmedical.Entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName="doctors")

data class Doctor (
    @PrimaryKey
    @NonNull
    var doctorID:Long,
    var firstName:String,
    var lastName:String,
    var speciality:String

)
