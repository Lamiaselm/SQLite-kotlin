package com.example.rdvmedical.Entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Date


@Entity (tableName="bookings",foreignKeys =
        arrayOf(
                ForeignKey(entity = Doctor::class,
                        parentColumns = arrayOf("doctorID"),
                        childColumns = arrayOf("doctorID"),
                        onDelete = ForeignKey.CASCADE),
                ForeignKey(entity = Treatment::class,
                        parentColumns = arrayOf("treatmentID"),
                        childColumns = arrayOf("treatmentID"),
                        onDelete = ForeignKey.CASCADE)
                  ))

data class Booking (
        @PrimaryKey
        val bookingID:Long,
        val doctorID:String,   //Clé etrangère
        val treatmentID:Long?, // un booking sans traitement
        val bookingDate: Date,
        val bookingTime:String
)