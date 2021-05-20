package com.example.rdvmedical.Interfaces

import androidx.room.*
import com.example.rdvmedical.Entities.Treatment


@Dao
interface TreatmentDao {

    @Insert
    fun addTreatment(treatment: Treatment)
    @Delete
    fun deleteTreatment(treatment: Treatment)
    @Update
    fun updateTreatment(treatment: Treatment)
    @Query("select * from treatments")
    fun getAllTreatment():List<Treatment>
}