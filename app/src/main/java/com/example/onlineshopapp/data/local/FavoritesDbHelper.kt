package com.example.onlineshopapp.data.local

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FavoritesDbHelper(
    context: Context,
) : SQLiteOpenHelper(
        context,
        DATABASE_NAME,
        null,
        DATABASE_VERSION,
    ) {
    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            """
            CREATE TABLE $TABLE_FAVORITES (
                id INTEGER PRIMARY KEY,
                title TEXT,
                price REAL,
                imageUrl TEXT
            )
            """.trimIndent()

        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int,
    ) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_FAVORITES")
        onCreate(db)
    }

    fun insertFavorite(favorite: FavoriteEntity) {
        val db = writableDatabase

        val values =
            ContentValues().apply {
                put("id", favorite.id)
                put("title", favorite.title)
                put("price", favorite.price)
                put("imageUrl", favorite.imageUrl)
            }

        db.insert(TABLE_FAVORITES, null, values)
        db.close()
    }

    fun getAllFavorites(): MutableList<FavoriteEntity> {
        val favoriteList = mutableListOf<FavoriteEntity>()

        val db = readableDatabase

        val cursor =
            db.rawQuery(
                "SELECT * FROM $TABLE_FAVORITES",
                null,
            )

        if (cursor.moveToFirst()) {
            do {
                val favorite =
                    FavoriteEntity(
                        id = cursor.getInt(0),
                        title = cursor.getString(1),
                        price = cursor.getDouble(2),
                        imageUrl = cursor.getString(3),
                    )

                favoriteList.add(favorite)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return favoriteList
    }

    fun deleteFavorite(id: Int) {
        val db = writableDatabase

        db.delete(
            TABLE_FAVORITES,
            "id=?",
            arrayOf(id.toString()),
        )

        db.close()
    }

    companion object {
        private const val DATABASE_NAME = "favorites_db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_FAVORITES = "favorites"
    }

    fun updateFavoritePrice(
        id: Int,
        newPrice: Double,
    ) {
        val db = writableDatabase

        val values =
            ContentValues().apply {
                put("price", newPrice)
            }

        db.update(
            TABLE_FAVORITES,
            values,
            "id=?",
            arrayOf(id.toString()),
        )

        db.close()
    }
}
