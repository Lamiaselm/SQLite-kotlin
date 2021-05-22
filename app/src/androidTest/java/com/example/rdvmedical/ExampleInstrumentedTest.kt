package com.example.rdvmedical

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.rdvmedical.Entities.Booking
import com.example.rdvmedical.Entities.Doctor
import com.example.rdvmedical.Entities.Treatment
import org.junit.After
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.text.SimpleDateFormat
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    lateinit var mDataBase:AppDatabase
    val treatmentEndDate= SimpleDateFormat("dd/mm/yy").parse("20/06/21")
    val treatmentBegindate=SimpleDateFormat("dd/mm/yy").parse("10/05/21")
    val current=SimpleDateFormat("dd/mm/yy").parse("22/06/21")
    val bookingDate=SimpleDateFormat("dd/mm/yy").parse("13/04/21")

    @Before
    fun initDB() { mDataBase =
        Room.inMemoryDatabaseBuilder(InstrumentationRegistry. getInstrumentation().context,AppDatabase::class.java).build()
    }
    @Test
    fun testAddTreatment() {
        val doctor = Doctor(3,"Abdelkhalek","Zellat","Cardiologue")
        val treatment= Treatment(3,"heart attack","heart attack is dangerous disease must be controlled",treatmentBegindate,treatmentEndDate)
        val booking = Booking(3,3,3,bookingDate,"08:00pm")
        mDataBase?.getDoctorDao()?.addDoctor(doctor)
        mDataBase?.getTreatmentDao()?.addTreatment(treatment)
        mDataBase?.getBookingDao()?.addBooking(booking)


        val listTreatment = mDataBase?.getTreatmentDao()?.getAllTreatment().get(0)
        System.out.println("result  "+listTreatment)
        assertEquals(treatment,listTreatment)
    }
    @Test
    fun testgetCurrentTreatment() {
        val treatmentEndDate= SimpleDateFormat("dd/mm/yy").parse("20/06/21")
        val treatmentBegindate=SimpleDateFormat("dd/mm/yy").parse("10/05/21")
        val current=SimpleDateFormat("dd/mm/yy").parse("09/06/21")
        val bookingDate=SimpleDateFormat("dd/mm/yy").parse("13/04/21")
        val doctor = Doctor(3,"Abdelkhalek","Zellat","Cardiologue")
        val treatment= Treatment(3,"heart attack","heart attack is dangerous disease must be controlled",treatmentBegindate,treatmentEndDate)
        val booking = Booking(3,3,3,bookingDate,"08:00pm")
        mDataBase?.getDoctorDao()?.addDoctor(doctor)
        mDataBase?.getTreatmentDao()?.addTreatment(treatment)
        mDataBase?.getBookingDao()?.addBooking(booking)

        val currentTime: Date = Calendar.getInstance().getTime()
        print(currentTime)
        val result= mDataBase?.getTreatmentDao()?.getCurrentTreatment(current)
        //System.out.println("hey"+result)
        //assertEquals(1,result.size)
        assertEquals(treatment,result.get(0))
    }
    @Test
    fun testgetTreatmentByDoctor() {
        val treatmentEndDate= SimpleDateFormat("dd/mm/yy").parse("20/06/21")
        val treatmentBegindate=SimpleDateFormat("dd/mm/yy").parse("10/05/21")
        val current=SimpleDateFormat("dd/mm/yy").parse("09/06/21")
        val bookingDate=SimpleDateFormat("dd/mm/yy").parse("13/04/21")

        val doctor = Doctor(3,"Abdelkhalek","Zellat","Cardiologue")
        val treatment= Treatment(3,"heart attack","heart attack is dangerous disease must be controlled",treatmentBegindate,treatmentEndDate)
        val booking = Booking(3,3,3,bookingDate,"08:00pm")

        mDataBase?.getDoctorDao()?.addDoctor(doctor)
        mDataBase?.getTreatmentDao()?.addTreatment(treatment)
        mDataBase?.getBookingDao()?.addBooking(booking)

        val currentTime: Date = Calendar.getInstance().getTime()
        val query= mDataBase?.getTreatmentDao()?.getCurrentTreatmentByDoctor(3,current)
        assertEquals(treatment,query)
    }

    @After
    fun closeDb(){ mDataBase?.close()
    }
}