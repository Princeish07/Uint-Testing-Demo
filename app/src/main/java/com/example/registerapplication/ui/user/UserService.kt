package com.example.registerapplication.ui.user

import com.example.registerapplication.other.LoginStatus

class UserService(val userRepository: UserRepository) {

    fun login(email:String,password:String):String{
       var status = userRepository.loginUser(email, password);
        return  when(status){
            LoginStatus.SUCCESS -> "Success Logged In"
            LoginStatus.INVALID_USER -> "Invalid user"
            LoginStatus.INVALID_PASSWORD-> "Please enter valid password"
            else -> "Failed"
        }
    }
}