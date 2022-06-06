package com.example.my_dz_lesson1_daniyare.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.my_dz_lesson1_daniyare.model.News

@Database (entities = [News::class],version= 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun newsDao():Dao
}