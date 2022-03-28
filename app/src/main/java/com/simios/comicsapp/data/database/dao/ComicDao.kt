package com.simios.comicsapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.simios.comicsapp.data.database.entities.ComicEntity

@Dao
interface ComicDao {

    @Query("SELECT * FROM  comic_table ORDER BY num DESC")
    suspend fun getAllComicts():List<ComicEntity>

    @Insert
    suspend fun insertComic(comic:ComicEntity)

    @Query("DELETE FROM comic_table")
    suspend fun deleteAllComics()
}