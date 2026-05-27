package com.example.onlineshopapp

import com.example.onlineshopapp.data.local.FavoriteEntity
import org.junit.Assert.assertEquals
import org.junit.Test

class FavoriteEntityTest {
    @Test
    fun favoritePrice_updateSuccessfully() {
        val favorite =
            FavoriteEntity(
                id = 1,
                title = "Apple Watch",
                price = 150.0,
                imageUrl = "",
            )

        assertEquals(150.0, favorite.price, 0.0)
    }

    @Test
    fun favoriteTitle_isCorrect() {
        val favorite =
            FavoriteEntity(
                id = 2,
                title = "Samsung Watch",
                price = 200.0,
                imageUrl = "",
            )

        assertEquals("Samsung Watch", favorite.title)
    }
}
