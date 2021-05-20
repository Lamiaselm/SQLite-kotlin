package com.example.rdvmedical.Interfaces

import androidx.room.*
import com.example.rdvmedical.Entities.Booking


@Dao

interface BookingDao {
    @Insert
    fun addBooking(booking: Booking)
    @Delete
    fun deleteBooking(booking: Booking)
    @Update
    fun updateBooking(booking: Booking)
    @Query("select * from bookings")
    fun getAllBooking():List<Booking>
}