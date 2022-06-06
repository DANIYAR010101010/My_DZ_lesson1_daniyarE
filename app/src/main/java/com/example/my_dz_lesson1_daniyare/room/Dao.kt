package com.example.my_dz_lesson1_daniyare.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.my_dz_lesson1_daniyare.model.News


@Dao
interface Dao {

    @Query("SELECT * FROM News")
    fun getAll(): List<News>
    @Insert
    fun insert (news: News)
}