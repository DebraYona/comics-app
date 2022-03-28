package com.simios.comicsapp.domain.model

import com.simios.comicsapp.data.database.entities.ComicEntity
import com.simios.comicsapp.data.model.ComicModel

data class Comic(
    val month: String,
    val code: Int,
    val link: String,
    val year: String,
    val safeTitle: String,
    val transcript: String,
    val alt: String,
    val img: String,
    val title: String,
    val day: String,
)

fun ComicModel.toDomain() =
    Comic(month, code, link, year, safeTitle, transcript, alt, img, title, day)

fun ComicEntity.toDomain() =
    Comic(month, code, link, year, safeTitle, transcript, alt, img, title, day)
