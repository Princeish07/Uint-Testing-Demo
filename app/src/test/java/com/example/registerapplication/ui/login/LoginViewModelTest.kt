package com.example.registerapplication.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.registerapplication.data.model.LoginModel
import com.example.registerapplication.other.Constant
import com.example.registerapplication.other.Status
import com.google.common.truth.Truth.assertThat
import getOrAwaitValue
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {
    /**
     * if user name is empty
     * if user name length is less than 2
     * if password is empty
     * if password length is length is less than 5
     */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: LoginViewModel;

    @Before
    fun setup(){
        viewModel = LoginViewModel();
    }

    @Test
    fun `checkPalindrom_inputString_Level _Return True`(){
       val isPalindrom =  viewModel.isPalindrome("SataS");
        assertEquals(true,isPalindrom);

    }

    @Test
    fun `checkPalindrom_inputString_Mohan _Expected False`(){
        val isPalindrom =  viewModel.isPalindrome("Mohan");
        assertEquals(false,isPalindrom);

    }





    @Test
    fun `insert user name empty_Return Error`(){
        val loginModel = LoginModel(userName = "Virat", password = "virushka");
        viewModel.login(loginModel);
        val value = viewModel.loginResponse.getOrAwaitValue();

        Assert.assertEquals(Constant.successfullyLoggedIn,value.getContentIfNotHandled()?.message)

    }


    @Test
    fun `insert first name with len 2_Return Error`(){
        val loginModel = LoginModel(userName = "Virat", password = "virushka");
        viewModel.login(loginModel);
        val value = viewModel.loginResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyLoggedIn,value.getContentIfNotHandled()?.message)

    }


    @Test
    fun `insert password empty_Return Error`(){
        val loginModel = LoginModel(userName = "Virat", password = "virushka");
        viewModel.login(loginModel);
        val value = viewModel.loginResponse.getOrAwaitValue();
        Assert.assertEquals(Constant.successfullyLoggedIn,value.getContentIfNotHandled()?.message)

    }

    @Test
    fun `insert password with len 5_Return Error`(){
        val loginModel = LoginModel(userName = "Virat", password = "virushka");
        viewModel.login(loginModel);
        val value = viewModel.loginResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyLoggedIn,value.getContentIfNotHandled()?.message)

    }

    @Test
    fun `correct input _Return Success`(){
        val loginModel = LoginModel(userName = "Virat", password = "virushka");
        viewModel.login(loginModel);
        val value = viewModel.loginResponse.getOrAwaitValue();
        assertEquals(Constant.successfullyLoggedIn,value.getContentIfNotHandled()?.message)

    }
}