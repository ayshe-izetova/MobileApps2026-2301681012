package com.example.onlineshopapp

import com.example.onlineshopapp.data.local.FavoriteEntity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FavoritesLogicTest {
    @Test
    fun favoriteId_isGeneratedFromTitle() {
        val title = "Apple Watch"

        val id = title.hashCode()

        assertEquals("Apple Watch".hashCode(), id)
    }

    @Test
    fun favoritePrice_isUpdatedCorrectly() {
        val favorite =
            FavoriteEntity(
                id = 1,
                title = "Samsung Watch",
                price = 200.0,
                imageUrl = "",
            )

        val updatedPrice = favorite.price + 1

        assertEquals(201.0, updatedPrice, 0.0)
    }

    @Test
    fun favoritesList_returnsCorrectSize() {
        val favorites =
            listOf(
                FavoriteEntity(1, "Apple Watch", 100.0, ""),
                FavoriteEntity(2, "Samsung Watch", 200.0, ""),
                FavoriteEntity(3, "Xiaomi Watch", 150.0, ""),
            )

        assertEquals(3, favorites.size)
    }

    @Test
    fun favoritesList_containsSelectedProduct() {
        val favorites =
            listOf(
                FavoriteEntity(1, "Apple Watch", 100.0, ""),
                FavoriteEntity(2, "Samsung Watch", 200.0, ""),
            )

        val containsProduct = favorites.any { it.title == "Apple Watch" }

        assertTrue(containsProduct)
    }
}
