package com.example.registerapplication.ui.login

import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.fragment.app.testing.withFragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.example.registerapplication.R
import com.example.registerapplication.launchFragmentInHiltContainer
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

@MediumTest
@ExperimentalCoroutinesApi
class LoginFragmentTest{

    /**
     * Check first Screen is login
     * Check if after navigation moving to register screen
     */

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testCurrentScreen() {
        val scenario = launchFragmentInContainer<LoginFragment>()
        scenario.onFragment { fragment ->
            // Verify fragment initialization and UI elements
            assertNotNull(fragment.view)
            assertEquals("Login Screen1", fragment.view?.findViewById<TextView>(R.id.tv_login_heading)?.text)
        }
    }

    @Test
    fun clickingSignUpButton_navigateToSignUpScreen(){
        val navController = mock(NavController::class.java);
        val titleScenario = launchFragmentInContainer<LoginFragment>()

        titleScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        onView(ViewMatchers.withId(R.id.btn_signUp1)).perform(ViewActions.click())
        Mockito.verify(navController).navigate(R.id.action_loginFragment_to_registrationFragment)
    }




}