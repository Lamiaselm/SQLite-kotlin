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

    @Query("Select * from treatments where :currentDate<treatmentEndDate")
    fun getCurrentTreatment(currentDate: Date):List<Treatment>
    //Récuperer le traitement en cours d'un docteur donné
    @Query("select * from treatments tr join bookings bk on tr.treatmentID=bk.treatmentID where bk.doctorID=:doctorID and :currentDate<tr.treatmentEndDate")
    fun getCurrentTreatmentByDoctor(doctorID:Int,currentDate: Date):Treatment
}