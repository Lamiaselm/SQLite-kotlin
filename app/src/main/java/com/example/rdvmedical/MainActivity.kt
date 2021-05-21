package com.example.rdvmedical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.rdvmedical.Entities.Doctor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appDatabase = Room.databaseBuilder(this,AppDatabase::class.java,"dbDoctor")
            .allowMainThreadQueries().build()
        val doctor = Doctor("Lamia","Selmane","Ophtalmologue,",1)
        appDatabase.getDoctorDao().addDoctor(doctor)
        appDatabase.getDoctorDao().getAllDoctors()
    }
}