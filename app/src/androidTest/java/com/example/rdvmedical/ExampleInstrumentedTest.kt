package com.example.rdvmedical

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.rdvmedical.Entities.Booking
import com.example.rdvmedical.Entities.Doctor
import com.example.rdvmedical.Entities.Treatment
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
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

    //date now
    var sdf: SimpleDateFormat? = SimpleDateFormat("dd/mm/yy")
    var cal = Calendar.getInstance()

    var now = cal.time // set the current datetime in a Date-object


    // SimpleDateFormat.format( Date date ) returns a formatted string
    // with the predefined format
    var mTimeString = sdf!!.format(now)


    val treatmentEndDate= SimpleDateFormat("dd/mm/yy").parse("20/06/21")
    val treatmentBegindate=SimpleDateFormat("dd/mm/yy").parse("10/05/21")
    val current=SimpleDateFormat("dd/mm/yy").parse("09/06/21")
    val bookingDate=SimpleDateFormat("dd/mm/yy").parse("13/04/21")

    val doctor = Doctor(3,"Lamia","Selmane","Cardiologue")
    val treatment= Treatment(3,"heart attack","heart attack is dangerous disease must be controlled",treatmentBegindate,treatmentEndDate)
    val booking = Booking(3,3,3,bookingDate,"08:00pm")

    @Before
    fun initDB() { mDataBase =
        Room.inMemoryDatabaseBuilder(InstrumentationRegistry. getInstrumentation().context,AppDatabase::class.java).build()
    }

    @Test
    fun testAddTreatment() {

        mDataBase?.getDoctorDao()?.addDoctor(doctor)
        mDataBase?.getTreatmentDao()?.addTreatment(treatment)
        mDataBase?.getBookingDao()?.addBooking(booking)


        val listTreatment = mDataBase?.getTreatmentDao()?.getAllTreatment().get(0)
        System.out.println("result  "+listTreatment)
        assertEquals(treatment,listTreatment)
    }
    @Test
    fun testgetCurrentTreatment() {

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


        mDataBase?.getDoctorDao()?.addDoctor(doctor)
        mDataBase?.getTreatmentDao()?.addTreatment(treatment)
        mDataBase?.getBookingDao()?.addBooking(booking)

        val currentTime: Date = Calendar.getInstance().getTime()
        val query= mDataBase?.getTreatmentDao()?.getCurrentTreatmentByDoctor("Lamia",current)
        assertEquals(treatment,query)
    }

    @After
    fun closeDb(){ mDataBase?.close()
    }
}