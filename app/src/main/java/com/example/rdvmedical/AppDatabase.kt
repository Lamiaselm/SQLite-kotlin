package com.example.rdvmedical

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rdvmedical.Entities.Booking
import com.example.rdvmedical.Entities.Doctor
import com.example.rdvmedical.Entities.Treatment
import com.example.rdvmedical.Interfaces.BookingDao
import com.example.rdvmedical.Interfaces.DoctorDao
import com.example.rdvmedical.Interfaces.TreatmentDao

@Database(entities = arrayOf(Doctor::class,Booking::class,Treatment::class),version = 1)
abstract class AppDatabase :RoomDatabase () {
    abstract fun getDoctorDao():DoctorDao
    abstract fun getBookingDao():BookingDao
    abstract fun getTreatmentDao():TreatmentDao
}


