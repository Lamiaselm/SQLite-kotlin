package com.example.rdvmedical.Entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName="doctors",foreignKeys =
        arrayOf(
        ForeignKey(entity = Booking::class,
            parentColumns = arrayOf("bookingID"),
            childColumns = arrayOf("bookingID"),
            onDelete = ForeignKey.CASCADE)

))
data class Doctor (
    @PrimaryKey
    @NonNull
    var doctorID:String,
    var firstName:String,
    var lastName:String, // A VERIFIER CUZ I FOUND DOUBLE ON THE TP LOL
    var speciality:String,
    var bookingID:Long?
)
