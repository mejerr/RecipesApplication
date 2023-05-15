package com.example.recipes_app.data.database.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recipes_app.models.FoodRecipe
import com.example.recipes_app.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}