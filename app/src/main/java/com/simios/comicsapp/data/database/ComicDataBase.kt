package com.simios.comicsapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simios.comicsapp.data.database.dao.ComicDao
import com.simios.comicsapp.data.database.entities.ComicEntity

@Database(entities = [ComicEntity::class], version = 1)
abstract class ComicDataBase:RoomDatabase() {

    abstract  fun getComicDao(): ComicDao
}