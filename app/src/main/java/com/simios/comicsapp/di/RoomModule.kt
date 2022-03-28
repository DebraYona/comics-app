package com.simios.comicsapp.di

import android.content.Context
import androidx.room.Room
import com.simios.comicsapp.data.database.ComicDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val COMIC_DATABASE_NAME = "comic_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ComicDataBase::class.java, COMIC_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideComicDao(db: ComicDataBase) = db.getComicDao()
}