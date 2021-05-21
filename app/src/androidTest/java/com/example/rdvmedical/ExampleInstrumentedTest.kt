package com.example.rdvmedical

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.rdvmedical.Entities.Doctor
import org.junit.After
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    lateinit var mDataBase:AppDatabase
    @Before
    fun initDB() { mDataBase =
        Room.inMemoryDatabaseBuilder(InstrumentationRegistry. getInstrumentation().context,AppDatabase::class.java).build()
    }
    @Test
    fun testInsertAndGetDoctor() {
        val doctor1 = Doctor(1,"Lamia","Selmane","Ophtalmologue")
        mDataBase?.getDoctorDao()?.addDoctor(doctor1)
        val listDoc = mDataBase?.getDoctorDao()?.getAllDoctors().get(0)
        assertEquals(doctor1,listDoc)
    }
    @After
    fun closeDb(){ mDataBase?.close()
    }
}