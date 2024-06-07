package com.example.registerapplication.other

object Constant {

    const val  MIN_USER_NAME_LENGTH = 2;
    const val  MIN_PASSWORD_LENGTH = 6;

    const  val emptyUserName = "Please enter user name";
    const  val invalidUserName = "Please enter valid user name";
    const val emptyPassword = "Please enter password";
    const val invalidPassword = "Password length should be more than $MIN_PASSWORD_LENGTH"
    const val emptyFirstName = "Please enter first name";
    const val emptyLastName = "Please enter last name";
    const val emptyEmail = "Please enter email";
    const  val invalidEmail = "Please enter valid email";
    const val emptyConfirmPassword = "Please enter confirm password";
    const  val passwordDoesMatched = "Confirm password doesn't matched";
    const val successfullyLoggedIn =  "Successfully Logged in"
    const val successfullyRegistered =  "Successfully Registered"

}

enum class LoginStatus{
    SUCCESS,
    INVALID_PASSWORD,
    INVALID_USER,
    FAILED
}