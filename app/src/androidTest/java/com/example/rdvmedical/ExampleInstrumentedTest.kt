package com.example.rdvmedical

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
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
    @Before
    fun initDB() { mDataBase =
        Room.inMemoryDatabaseBuilder(InstrumentationRegistry. getInstrumentation().context,AppDatabase::class.java).build()
    }
    @Test
    fun testAddTreatment() {

        val treatment= Treatment(3,"heart attack","heart attack is dangerous disease must be controlled",treatmentBegindate,treatmentEndDate)

        mDataBase?.getTreatmentDao()?.addTreatment(treatment)

        val listTreatment = mDataBase?.getTreatmentDao()?.getAllTreatment().get(0)
        assertEquals(treatment,listTreatment)
    }
    @Test
    fun testgetCurrentTreatment() {
        val currentTime: Date = Calendar.getInstance().getTime()
        val result:List<Treatment> = mDataBase?.getTreatmentDao()?.getCurrentTreatment(currentTime)
        val listTreatment:MutableList<Treatment> = mutableListOf(Treatment(1,"heart attack","heart attack is dangerous disease must be controlled",treatmentBegindate,treatmentEndDate))
        assertEquals(result,listTreatment)
    }
    @Test
    fun testgetTreatmentByDoctor() {
        val currentTime: Date = Calendar.getInstance().getTime()
        mDataBase?.getTreatmentDao()?.getCurrentTreatment(currentTime)
       // val listTreatment:List<Treatment> =
               // assertEquals(doctor1,listDoc)
    }

    @After
    fun closeDb(){ mDataBase?.close()
    }
}