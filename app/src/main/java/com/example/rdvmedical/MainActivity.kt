package com.example.rdvmedical

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rdvmedical.Entities.Doctor
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RoomService.context=this
        val currentTime: Date = Calendar.getInstance().getTime()
        val doctor = Doctor("1","Lamia","Selmane","Ophtalmologue,")
        RoomService.appDatabase.getDoctorDao().addDoctor(doctor)
        RoomService.appDatabase.getDoctorDao().getAllDoctors()
        RoomService.appDatabase.getTreatmentDao().getCurrentTreatment(currentTime)

    }
}