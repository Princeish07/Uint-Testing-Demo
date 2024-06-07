package com.example.registerapplication.ui.registration

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.registerapplication.R
import com.example.registerapplication.ui.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class RegistrationFragmentTest{
    /**
     *
     */

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRegistrationUI() {
//         Navigate to registration screen if needed
         onView(withId(R.id.btn_signUp1)).perform(click())

        // Enter registration details
        onView(withHint("Enter first name")).perform(typeText("John"))
        onView(withHint("Enter last name")).perform(typeText("Doe"))
        onView(withHint("Enter email")).perform(typeText("john.doe@example.com"))
        onView(withHint("Enter password")).perform(typeText("password"), closeSoftKeyboard())
        onView(withHint("Enter confirm password")).perform(typeText("password"), closeSoftKeyboard())

        // Click register button
        onView(withText("Register Now")).perform(click())

        // Verify registration success
        onView(withText("Registration Successful")).check(matches(isDisplayed()))
    }

}