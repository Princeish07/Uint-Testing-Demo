package com.example.registerapplication.other

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SharedPreferencesTest {

    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        sharedPreferencesHelper = SharedPreferencesHelper(context)
    }

    @Test
    fun testSaveAndRetrieveData() {
        val testKey = "userName"
        val testValue = "Jatin"

        // Save data to SharedPreferences
        sharedPreferencesHelper.saveData(testKey, testValue)

        // Retrieve data from SharedPreferences
        val retrievedValue = sharedPreferencesHelper.getData(testKey)

        // Assert that the retrieved value matches the saved value
        assertEquals(testValue, retrievedValue)
    }
}