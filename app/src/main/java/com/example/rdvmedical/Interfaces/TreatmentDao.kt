package com.example.rdvmedical.Interfaces

import android.text.TextUtils
import androidx.room.*
import com.example.rdvmedical.Entities.Treatment
import java.time.format.DateTimeFormatter
import java.util.*


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
    // Recuperer la liste des traitement en cours

    @Query("Select * from treatments where tratmentEndDate < :currentDate")
    fun getCurrentTreatment(currentDate: Date):List<Treatment>
    //Récuperer le traitement en cours d'un docteur donné
    @Query("select * from treatments where doctorID=:doctorID and tratmentEndDate < :currentDate ")
    fun getCurrentTreatmentByDoctor(doctorID:Int,currentDate: Date):Treatment
}