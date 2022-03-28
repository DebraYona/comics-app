package com.simios.comicsapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "comic_table")
data class ComicEntity(
    @ColumnInfo(name = "month") val month: String,
    @ColumnInfo(name ="num") val code: Number,
    @ColumnInfo(name ="link") val link: String,
    @ColumnInfo(name ="year") val year: String,
    @ColumnInfo(name ="safe_title") val safeTitle: String,
    @ColumnInfo(name ="transcript") val transcript: String,
    @ColumnInfo(name ="alt") val alt: String,
    @ColumnInfo(name ="img") val img: String,
    @ColumnInfo(name ="title") val title: String,
    @ColumnInfo(name ="day") val day: String,
)