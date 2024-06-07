package com.example.registerapplication.other

const val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

fun String.isEmailValid():Boolean{
       return this.matches(emailRegex.toRegex())

}
