package com.example.rdvmedical.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date


@Entity (tableName="bookings",foreignKeys = arrayOf("doctorID"))

data class Booking (
        @PrimaryKey
        val bookingID:Long,
        val doctorID:String,   //Clé etrangère
        val treatmentID:Long?, // un booking sans traitement
        val bookingDate: Date,
        val bookingTime:String
)