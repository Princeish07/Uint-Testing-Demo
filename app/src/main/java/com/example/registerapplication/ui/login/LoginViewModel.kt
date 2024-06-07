package com.example.registerapplication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.registerapplication.data.model.LoginModel
import com.example.registerapplication.data.response.UserResponse
import com.example.registerapplication.other.Constant
import com.example.registerapplication.other.Constant.MIN_PASSWORD_LENGTH
import com.example.registerapplication.other.Constant.MIN_USER_NAME_LENGTH
import com.example.registerapplication.other.Event
import com.example.registerapplication.other.Resource
import com.example.registerapplication.other.SharedPreferencesHelper
import com.example.registerapplication.other.Status

class LoginViewModel : ViewModel() {

    fun isPalindrome(str: String): Boolean {
        var start = 0
        var end = str.length - 1
        while (start < end) {
            if (str[start] != str[end]) {
                return false
            }
            start++
            end--
        }
        return true
    }









    //Login
    private val _userName:MutableLiveData<String> = MutableLiveData("");
    val getUserName:LiveData<String> = _userName;

    private val _password:MutableLiveData<String> = MutableLiveData("");
    val getPassword:LiveData<String> = _password;

     val _loginResponse = MutableLiveData<Event<Resource<UserResponse>>>();
    val loginResponse:LiveData<Event<Resource<UserResponse>>> = _loginResponse;






    private fun validationCheck(loginModel: LoginModel):Boolean{
        if (loginModel.userName.isEmpty()){
            _loginResponse.value=Event(Resource(status = Status.ERROR,data = null,message = Constant.emptyUserName))
            return false
        }
        else if(loginModel.userName.length<=MIN_USER_NAME_LENGTH){
            _loginResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = Constant.invalidUserName)))

            return  false;
        }
        if (loginModel.password.isEmpty()){
            _loginResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = Constant.emptyPassword)))
            return false
        }
        else if(loginModel.password.length<= MIN_PASSWORD_LENGTH){
            _loginResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = Constant.invalidPassword)))

            return  false;
        }
    return  true
    }


    fun login(loginModel: LoginModel){
        if(validationCheck(loginModel)){
            if(loginModel== LoginModel("Virat","virushka")) {
                _loginResponse.postValue(
                    Event(
                        Resource(
                            status = Status.SUCCESS,
                            data = UserResponse(
                                firstName = loginModel.userName,
                                lastName = "Kohli",
                                email = "vk18@yopmail.com"
                            ),
                            message = "Successfully Logged in"
                        )
                    )
                )
            }
        else{
                _loginResponse.postValue(
                    Event(
                        Resource(
                            status = Status.ERROR,
                            data = null,
                            message = "Invalid Login Credentials"
                        )
                    )
                )
            }
        }
    }





}