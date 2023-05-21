package com.example.recipes_app.data

import com.example.recipes_app.data.database.RecipesDao
import com.example.recipes_app.data.database.entites.FavouritesEntity
import com.example.recipes_app.data.database.entites.RecipesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
) {
    fun readRecipes(): Flow<List<RecipesEntity>> {
        return recipesDao.readRecipes()
    }

    fun readFavoriteRecipes(): Flow<List<FavouritesEntity>> {
        return recipesDao.readFavoriteRecipes()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity) {
        recipesDao.insertRecipes(recipesEntity)
    }

    suspend fun insertFavoriteRecipes(favoritesEntity: FavouritesEntity) {
        recipesDao.insertFavouriteRecipe(favoritesEntity)
    }

    suspend fun deleteFavoriteRecipe(favoritesEntity: FavouritesEntity) {
        recipesDao.deleteFavoriteRecipe(favoritesEntity)
    }

    suspend fun deleteAllFavoriteRecipes() {
        recipesDao.deleteAllFavoriteRecipes()
    }
}