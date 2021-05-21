package com.example.rdvmedical

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rdvmedical.Interfaces.BookingDao
import com.example.rdvmedical.Interfaces.DoctorDao
import com.example.rdvmedical.Interfaces.TreatmentDao

@Database
abstract class AppDatabase :RoomDatabase () {
    abstract fun getDoctorDao():DoctorDao
    abstract fun getBookingDao():BookingDao
    abstract fun getTreatmentDao():TreatmentDao
}