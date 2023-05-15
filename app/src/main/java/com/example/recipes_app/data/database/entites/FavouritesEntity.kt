package com.example.recipes_app.data.database.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recipes_app.util.Constants.Companion.FAVOURITE_RECIPES_TABLE
import com.example.recipes_app.models.Result

@Entity(tableName = FAVOURITE_RECIPES_TABLE)
class FavouritesEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var result: Result
) {
}