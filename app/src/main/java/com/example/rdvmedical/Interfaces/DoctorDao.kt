package com.example.rdvmedical.Interfaces

import androidx.room.*
import com.example.rdvmedical.Entities.Doctor

@Dao
interface DoctorDao {

    @Insert
    fun addDoctor(doctor:Doctor)
    @Delete
    fun deleteDoctor(doctor: Doctor)
    @Update
    fun updateDoctor(doctor: Doctor)
    @Query("select * from doctors")
    fun getAllDoctors():List<Doctor>
}