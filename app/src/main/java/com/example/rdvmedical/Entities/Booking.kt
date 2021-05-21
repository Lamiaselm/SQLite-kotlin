package com.example.rdvmedical.Entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Date


@Entity (tableName="bookings",foreignKeys =
        arrayOf(
                ForeignKey(entity = Treatment::class,
                        parentColumns = arrayOf("treatmentID"),
                        childColumns = arrayOf("treatmentID"),
                        onDelete = ForeignKey.CASCADE)
                  ))

data class Booking (

        @PrimaryKey
        @NonNull
        var bookingID:Long,
        val treatmentID:Long,
        val bookingDate: Date,
        val bookingTime:String
)
