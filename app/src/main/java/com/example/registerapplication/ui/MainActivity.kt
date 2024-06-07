package com.example.registerapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registerapplication.R
import com.example.registerapplication.databinding.ActivityMainBinding
import com.example.registerapplication.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
    }


}