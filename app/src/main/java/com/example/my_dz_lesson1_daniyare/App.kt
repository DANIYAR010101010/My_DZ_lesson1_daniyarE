package com.example.my_dz_lesson1_daniyare

import android.app.Application
import androidx.room.Room
import com.example.my_dz_lesson1_daniyare.room.AppDataBase

class App: Application() {
companion object{

    lateinit var dataBase: AppDataBase
}


    override fun onCreate() {
        super.onCreate()
        dataBase = Room.databaseBuilder(this,AppDataBase::class.java,"dataBase")
            .allowMainThreadQueries()
            .build()
    }

}