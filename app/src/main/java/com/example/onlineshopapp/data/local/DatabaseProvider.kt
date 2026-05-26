package com.example.onlineshopapp.data.local

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    @Volatile
    private var database: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return database ?: synchronized(this) {
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "online_shop_database",
            ).build().also {
                database = it
            }
        }
    }
}