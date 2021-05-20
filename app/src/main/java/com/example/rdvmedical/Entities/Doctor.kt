package com.example.rdvmedical.Entities

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

    var firstName:String,
    var lastName:Double,
    var speciality:String,
    var bookingID:Long?
)
{
    @PrimaryKey(autoGenerate = true)
    var doctorID:String?=null
}