package com.example.registerapplication.other

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("example_prefs", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}