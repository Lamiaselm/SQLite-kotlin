package com.example.rdvmedical

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rdvmedical.Entities.Booking
import com.example.rdvmedical.Entities.Doctor
import com.example.rdvmedical.Entities.Treatment
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RoomService.context=this

        val bookingDate=SimpleDateFormat("dd/mm/yy").parse("13/04/21")
        val treatmentBegindate=SimpleDateFormat("dd/mm/yy").parse("10/05/21")
        val treatmentEndDate=SimpleDateFormat("dd/mm/yy").parse("20/06/21")


        val currentTime: Date = Calendar.getInstance().getTime()
        val doctor = Doctor(3,"Abdelkhalek","Zellat","Cardiologue")
        val booking =Booking(3,3,2,bookingDate,"08:00pm")
        val treatment=Treatment(3,"heart attack","heart attack is dangerous disease must be controlled",treatmentBegindate,treatmentEndDate)
        // RoomService.appDatabase.getDoctorDao().addDoctor(doctor)
        //RoomService.appDatabase.getBookingDao().addBooking(booking)
       // RoomService.appDatabase.getTreatmentDao().addTreatment(treatment)




        RoomService.appDatabase.getTreatmentDao().getCurrentTreatment(currentTime)

    }
}