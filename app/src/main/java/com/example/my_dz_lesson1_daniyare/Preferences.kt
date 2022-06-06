package com.example.my_dz_lesson1_daniyare

import android.content.Context

class Preferences( context: Context) {
    private val preferences = context.getSharedPreferences("settings",Context.MODE_PRIVATE)

    fun saveState(){
        preferences.edit().putBoolean("isShown",true).apply()
    }
    fun isShown(): Boolean {
        return preferences.getBoolean("isShown",false)
    }
    fun saveName(string: String){
        preferences.edit().putString("name",string).apply()
    }
    fun getName (string: String) {
        preferences.getString("name",string)
    }
}