package com.example.registerapplication.ui.registration

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.registerapplication.data.model.RegistrationModel
import com.example.registerapplication.other.Constant
import com.example.registerapplication.other.Status
import com.google.common.truth.Truth
import getOrAwaitValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RegistrationViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule();

    lateinit var viewModel: RegistrationViewModel;

    @Before
    fun setup() {
        viewModel = RegistrationViewModel();
    }

    @Test
    fun `empty first _Return Error`() {
        val registrationModel = RegistrationModel(firstName ="Virat", lastName ="Kohli", email = "vk18@yopmail.com", password = "virushka", confirmPassword = "virushka");
        viewModel.registerNow(registrationModel);
        val value = viewModel.registrationResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyRegistered,value.getContentIfNotHandled()?.message)

    }

    @Test
    fun `empty last _Return Error`() {
        val registrationModel = RegistrationModel(firstName ="Virat", lastName ="Kohli", email = "vk18@yopmail.com", password = "virushka", confirmPassword = "virushka");
        viewModel.registerNow(registrationModel);
        val value = viewModel.registrationResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyRegistered,value.getContentIfNotHandled()?.message)

    }

    @Test
    fun `empty email _Return Error`() {
        val registrationModel = RegistrationModel(firstName ="Virat", lastName ="Kohli", email = "vk18@yopmail.com", password = "virushka", confirmPassword = "virushka");
        viewModel.registerNow(registrationModel);
        val value = viewModel.registrationResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyRegistered,value.getContentIfNotHandled()?.message)

    }

    @Test
    fun `invalid email _Return Error`() {
        val registrationModel = RegistrationModel(firstName ="Virat", lastName ="Kohli", email = "vk18@yopmail.com", password = "virushka", confirmPassword = "virushka");
        viewModel.registerNow(registrationModel);
        val value = viewModel.registrationResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyRegistered,value.getContentIfNotHandled()?.message)

    }


    @Test
    fun `empty password _Return Error`() {
        val registrationModel = RegistrationModel(firstName ="Virat", lastName ="Kohli", email = "vk18@yopmail.com", password = "virushka", confirmPassword = "virushka");
        viewModel.registerNow(registrationModel);
        val value = viewModel.registrationResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyRegistered,value.getContentIfNotHandled()?.message)

    }


    @Test
    fun `password len is less then 6 _Return Error`() {
        val registrationModel = RegistrationModel(firstName ="Virat", lastName ="Kohli", email = "vk18@yopmail.com", password = "virushka", confirmPassword = "virushka");
        viewModel.registerNow(registrationModel);
        val value = viewModel.registrationResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyRegistered,value.getContentIfNotHandled()?.message)

    }


    @Test
    fun `password and confirm password not matched _Return Error`() {
        val registrationModel = RegistrationModel(firstName ="Virat", lastName ="Kohli", email = "vk18@yopmail.com", password = "virushka", confirmPassword = "virushka");
        viewModel.registerNow(registrationModel);
        val value = viewModel.registrationResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyRegistered,value.getContentIfNotHandled()?.message)

    }

    @Test
    fun `correct input value _Return Success`() {
        val registrationModel = RegistrationModel(firstName ="Virat", lastName ="Kohli", email = "vk18@yopmail.com", password = "virushka", confirmPassword = "virushka");
        viewModel.registerNow(registrationModel);
        val value = viewModel.registrationResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyRegistered,value.getContentIfNotHandled()?.message)

    }
}