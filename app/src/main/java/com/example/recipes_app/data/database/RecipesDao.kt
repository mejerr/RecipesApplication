package com.example.recipes_app.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipes_app.data.database.entites.FavouritesEntity
import com.example.recipes_app.data.database.entites.RecipesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavouriteRecipe(favouritesEntity: FavouritesEntity)

    @Query("SELECT * FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>>

    @Query("SELECT * FROM favourite_recipes_table ORDER BY id ASC")
    fun readFavoriteRecipes(): Flow<List<FavouritesEntity>>

    @Delete
    suspend fun deleteFavoriteRecipe(favoritesEntity: FavouritesEntity)

    @Query("DELETE FROM favourite_recipes_table")
    suspend fun deleteAllFavoriteRecipes()
}