package com.example.rdvmedical

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rdvmedical.Entities.Booking
import com.example.rdvmedical.Entities.Doctor
import com.example.rdvmedical.Entities.Treatment
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RoomService.context=this

        // GET THE CURRENTY DATE //
        val currentdate=SimpleDateFormat("dd/mm/yy").parse("03/05/21")

        //******* ADD DOCOTRS ********* //
        val doc1 = Doctor(1,"Lamia","Selmane","Cardiologue")
        val doc2 = Doctor(2,"Noha","Nekamiche","Dentiste")
        val doc3 = Doctor(3,"Melly","Selmane","Ophtalmologue")

        RoomService.appDatabase.getDoctorDao().addDoctor(doc1)
        RoomService.appDatabase.getDoctorDao().addDoctor(doc2)
        RoomService.appDatabase.getDoctorDao().addDoctor(doc3)

        //******* ADD TREATMENTS ********* //
        val treatmentBegindate1=SimpleDateFormat("dd/mm/yy").parse("10/05/21")
        val treatmentBegindate2=SimpleDateFormat("dd/mm/yy").parse("13/05/21")
        val treatmentBegindate3=SimpleDateFormat("dd/mm/yy").parse("23/05/21")
        val treatmentEndDate1=SimpleDateFormat("dd/mm/yy").parse("09/05/21")
        val treatmentEndDate2=SimpleDateFormat("dd/mm/yy").parse("28/05/21")
        val treatmentEndDate3=SimpleDateFormat("dd/mm/yy").parse("03/06/21")

        val treatment1=Treatment(1,"coruna","Covid19 caused the death of millions of people",treatmentBegindate1,treatmentEndDate1)
        val treatment2=Treatment(2,"heart attack","heart attack ",treatmentBegindate2,treatmentEndDate2)
        val treatment3=Treatment(3,"injury","injury",treatmentBegindate3,treatmentEndDate3)

        RoomService.appDatabase.getTreatmentDao().addTreatment(treatment1)
        RoomService.appDatabase.getTreatmentDao().addTreatment(treatment2)
        RoomService.appDatabase.getTreatmentDao().addTreatment(treatment3)

        //******* ADD BOOKINGS ********* //
        val bookingDate1=SimpleDateFormat("dd/mm/yy").parse("13/05/21")
        val bookingDate2=SimpleDateFormat("dd/mm/yy").parse("20/04/21")
        val bookingDate3=SimpleDateFormat("dd/mm/yy").parse("28/03/21")

        val booking1 =Booking(1,1,1,bookingDate1,"08:00pm")
        val booking2 =Booking(2,2,2,bookingDate2,"08:00pm")
        val booking3 =Booking(3,3,3,bookingDate3,"08:00pm")

        RoomService.appDatabase.getBookingDao().addBooking(booking1)
        RoomService.appDatabase.getBookingDao().addBooking(booking2)
        RoomService.appDatabase.getBookingDao().addBooking(booking3)


        // TESTER LA FONCTION getCurrentTreatment //
         val result =RoomService.appDatabase.getTreatmentDao().getCurrentTreatment(currentdate)

        val i:Int
        aff1.setOnClickListener { view ->
            var i =0
                  while (i<result.size)
                  {
                      Toast.makeText(applicationContext, "Voici les traitement en cours : ${result[i].treatmentDescription}", Toast.LENGTH_LONG).show();
                      i++

                  }

         }
        // TESTER LA FONCTION GetCurrentTreatmentBydoctor //

        aff2.setOnClickListener{

            view->

            val firstName=editTextTextPersonName.getText().toString()
            val all = RoomService.appDatabase.getTreatmentDao().getCurrentTreatmentByDoctor(firstName,currentdate)

           if (firstName!=null)
             {
                 if (all!==null)
                 {
                     Toast.makeText(applicationContext, "Voici le traitement du medecin $firstName : ${all.treatmentDescription}", Toast.LENGTH_LONG).show();

                 }

                 else  {
                     Toast.makeText(applicationContext, "Aucun traitement pour le medecin $firstName ", Toast.LENGTH_LONG).show();

                 }
             }
             else {
                 Toast.makeText(applicationContext, "Veuillez saisir un nom du medecin", Toast.LENGTH_LONG).show();

             }



        }




    }
}