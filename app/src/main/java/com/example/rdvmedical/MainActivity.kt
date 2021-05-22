package com.example.rdvmedical

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rdvmedical.Entities.Booking
import com.example.rdvmedical.Entities.Doctor
import com.example.rdvmedical.Entities.Treatment
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RoomService.context=this

        val bookingDate=SimpleDateFormat("dd/mm/yy").parse("13/04/21")
        val treatmentBegindate=SimpleDateFormat("dd/mm/yy").parse("10/05/21")
        val treatmentEndDate=SimpleDateFormat("dd/mm/yy").parse("30/06/21")
        val treatmentEndDate2=SimpleDateFormat("dd/mm/yy").parse("25/06/21")

        val current=SimpleDateFormat("dd/mm/yy").parse("10/06/21")
   //     val currentTime: Date = Calendar.getInstance().getTime()
      //  print("current time is "+currentTime)


        val doctor = Doctor(10,"Melly","Selmane","Cardiologue")
        val booking =Booking(10,10,10,bookingDate,"08:00pm")
        val treatment=Treatment(10,"coruna","Covid19 caused the death of millions of people",treatmentBegindate,treatmentEndDate)
        // RoomService.appDatabase.getDoctorDao().addDoctor(doctor)
      //  RoomService.appDatabase.getTreatmentDao().addTreatment(treatment)
     //  RoomService.appDatabase.getBookingDao().addBooking(booking)



         val result =RoomService.appDatabase.getTreatmentDao().getCurrentTreatment(current)
        val i:Int
        aff1.setOnClickListener { view ->
        var i =1
                  while (i<result.size)
                  {
                      Toast.makeText(applicationContext, "Voici les traitement en cours : ${result[i].disease}", Toast.LENGTH_LONG).show();
                      i++

                  }





         }
        val ID=editTextTextPersonName.getText()
        val all = RoomService.appDatabase.getTreatmentDao().getCurrentTreatmentByDoctor("Lamia",current)
        aff2.setOnClickListener{
            view->
            Toast.makeText(applicationContext, "Voici le traitement du medecin : ${all.treatmentDescription}", Toast.LENGTH_LONG).show();

        }




    }
}