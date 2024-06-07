package com.example.registerapplication.ui.login

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class ParameterizedExample(val inputValue: String, val expectedValue: Boolean) {
    lateinit var viewModel: LoginViewModel;

    @Before
    fun setup() {
        viewModel = LoginViewModel();
    }

    @Test
    fun `checkPalindrom_inputString_Level _Return True`() {
        val isPalindrom = viewModel.isPalindrome(inputValue);
        Assert.assertEquals(expectedValue, isPalindrom);

    }

    companion object {

        @JvmStatic
        @Parameters(name = "{index}: {0} is palindome - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }
}