package com.example.registerapplication.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.registerapplication.data.model.LoginModel
import com.example.registerapplication.data.model.RegistrationModel
import com.example.registerapplication.data.response.UserResponse
import com.example.registerapplication.other.Constant
import com.example.registerapplication.other.Constant.emptyConfirmPassword
import com.example.registerapplication.other.Constant.emptyEmail
import com.example.registerapplication.other.Constant.emptyFirstName
import com.example.registerapplication.other.Constant.emptyLastName
import com.example.registerapplication.other.Constant.invalidEmail
import com.example.registerapplication.other.Constant.passwordDoesMatched
import com.example.registerapplication.other.Event
import com.example.registerapplication.other.Resource
import com.example.registerapplication.other.Status
import com.example.registerapplication.other.isEmailValid

class RegistrationViewModel:ViewModel() {

    //Register
    private val _firstName: MutableLiveData<String> = MutableLiveData("");
    val getFirstName: LiveData<String> = _firstName;

    private val _lastName: MutableLiveData<String> = MutableLiveData("");
    val getLast: LiveData<String> = _lastName;

    private val _signUpEmail: MutableLiveData<String> = MutableLiveData("");
    val getSignUpEmail: LiveData<String> = _signUpEmail;

    private val _password: MutableLiveData<String> = MutableLiveData("");
    val getPassword: LiveData<String> = _password;

    private val _confirmPassword: MutableLiveData<String> = MutableLiveData("");
    val getConfirmPassword: LiveData<String> = _confirmPassword;

    private val _registrationResponse = MutableLiveData<Event<Resource<UserResponse>>>();
    val registrationResponse:LiveData<Event<Resource<UserResponse>>> = _registrationResponse;




    fun validationCheck(registrationModel: RegistrationModel):Boolean{
        if (registrationModel.firstName.isEmpty()){
            _registrationResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = emptyFirstName)))
            return false
        }
        else if (registrationModel.lastName.isEmpty()){
            _registrationResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message =emptyLastName)))
            return false
        }
        else if (registrationModel.email.isEmpty()){
            _registrationResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = emptyEmail)))
            return false
        }
        else if (!registrationModel.email.isEmailValid()){
            _registrationResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = invalidEmail)))
            return false
        }

        else if (registrationModel.password.isEmpty()){
            _registrationResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = Constant.emptyPassword)))
            return false
        }
        else if(registrationModel.password.length<= Constant.MIN_PASSWORD_LENGTH){
            _registrationResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = Constant.invalidPassword)))

            return  false;
        }
        if (registrationModel.confirmPassword.isEmpty()){
            _registrationResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = emptyConfirmPassword)))
            return false
        }
        else if(registrationModel.password!=registrationModel.confirmPassword){
            _registrationResponse.postValue(Event(Resource(status = Status.ERROR,data = null,message = passwordDoesMatched)))

            return  false;
        }
        return  true
    }
    fun registerNow(registrationModel: RegistrationModel){
        if(validationCheck(registrationModel)){
            _registrationResponse.postValue(Event(Resource(status = Status.SUCCESS,data = UserResponse(firstName = registrationModel.firstName, lastName = "Kohli", email = "vk18@yopmail.com"),message = Constant.successfullyRegistered)))
        }
    }




}