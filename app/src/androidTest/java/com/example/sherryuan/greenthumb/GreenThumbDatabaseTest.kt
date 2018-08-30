package com.example.sherryuan.greenthumb

import android.arch.persistence.room.Room
import android.graphics.Bitmap
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.sherryuan.greenthumb.persistence.GreenThumbDatabase
import com.example.sherryuan.greenthumb.persistence.Plant
import com.example.sherryuan.greenthumb.persistence.PlantDao
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*

/**
 * Created by sherryuan on 2018-08-29.
 */

/**
 * Unit test for PlantDao
 */
@RunWith(AndroidJUnit4::class)
class GreenThumbDatabaseTest {
    private lateinit var plantDao: PlantDao
    private lateinit var testDatabase: GreenThumbDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        testDatabase = Room.inMemoryDatabaseBuilder(context, GreenThumbDatabase::class.java).build()
        plantDao = testDatabase.plantDao()
    }

    @Test
    @Throws(Exception::class)
    fun testPlantDaoQueries() {
        // create first plant with dummy values
        val plant1 = Plant(1, "", "rose", "red petals", 5, Date(1355270400000))
        plantDao.insert(plant1)

        // create second plant with dummy values
        val plant2 = Plant(2, "", "cactus", "spiky boi", 20, Date(1355540400000))
        plantDao.insert(plant2)

        // create second plant with dummy values
        val plant3 = Plant(3, "", "tomato", "delicious", 12, Date(1355520400000))
        plantDao.insert(plant3)

        // test that we can find the first Plant
        val plantById1 = plantDao.findById(1).blockingFirst()
        Assert.assertEquals(plantById1[0].name, plant1.name)
        Assert.assertEquals(plantById1[0].description, plant1.description)

        Assert.assertEquals(plantById1.size.toLong(), 1)

        // test that we can get all the Plants
        val allPlants = plantDao.loadAll().blockingFirst()
        Assert.assertEquals(allPlants[0].description, plant1.description)
        Assert.assertEquals(allPlants[1].description, plant2.description)
        Assert.assertEquals(allPlants[2].description, plant3.description)
        Assert.assertEquals(allPlants.size.toLong(), 3)
    }
}
