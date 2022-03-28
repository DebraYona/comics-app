package com.simios.comicsapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.simios.comicsapp.domain.model.Comic

@Entity(tableName = "comic_table")
data class ComicEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "month") val month: String,
    @ColumnInfo(name = "num") val code: Int,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "year") val year: String,
    @ColumnInfo(name = "safe_title") val safeTitle: String,
    @ColumnInfo(name = "transcript") val transcript: String,
    @ColumnInfo(name = "alt") val alt: String,
    @ColumnInfo(name = "img") val img: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "day") val day: String,
)

fun Comic.toDatabase() =
    ComicEntity(
        month = month,
        code = code,
        link = link,
        year = year,
        safeTitle = safeTitle,
        transcript = transcript,
        alt = alt,
        img = img,
        title = title,
        day = day
    )