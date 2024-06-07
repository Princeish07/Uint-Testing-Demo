package com.example.registerapplication.ui.user

import com.example.registerapplication.data.model.UserModel
import com.example.registerapplication.other.LoginStatus

class UserRepository {
    var users:List<UserModel> = listOf<UserModel>(
        UserModel(email = "princeish07@gmail.com", password = "12345678"),
        UserModel(email = "raman@gmail.com", password = "12345678"),
        UserModel(email = "vk18@gmail.com", password = "12345678")
    );

    fun loginUser(email:String, password:String):LoginStatus{
        val users = users.filter { user->user.email==email }
        return  if(users.size==1){
            if(users[0].password==password) {
                LoginStatus.SUCCESS
            }else{
                LoginStatus.INVALID_PASSWORD
            }
        }else{
            LoginStatus.INVALID_USER;
        }
    }

}