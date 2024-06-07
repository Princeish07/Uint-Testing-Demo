package com.example.registerapplication.ui.user

import com.example.registerapplication.other.LoginStatus
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest{
    @Mock
    lateinit var userRepository: UserRepository;

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this);
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LoginStatus.INVALID_USER)
    }


    @Test
    fun testLoggedIn(){
        var userService = UserService(userRepository);
       var output =  userService.login("rohan","123434")
        assertEquals("Invalid user",output)


    }
}