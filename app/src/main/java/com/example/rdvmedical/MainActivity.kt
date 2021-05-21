package com.example.rdvmedical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.rdvmedical.Entities.Doctor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RoomService.context=this
        val doctor = Doctor("1","Lamia","Selmane","Ophtalmologue,",1)
        RoomService.appDatabase.getDoctorDao().addDoctor(doctor)
        RoomService.appDatabase.getDoctorDao().getAllDoctors()

    }
}