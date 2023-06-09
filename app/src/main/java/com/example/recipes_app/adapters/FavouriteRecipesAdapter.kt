package com.example.recipes_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes_app.data.database.entites.FavouritesEntity
import com.example.recipes_app.databinding.FavouriteRecipesRowLayoutBinding
import com.example.recipes_app.ui.fragments.favorites.FavouriteRecipesFragmentDirections
import com.example.recipes_app.util.RecipesDiffUtil

class FavouriteRecipesAdapter : RecyclerView.Adapter<FavouriteRecipesAdapter.MyViewHolder>() {
    private var favoriteRecipes = emptyList<FavouritesEntity>()
    class MyViewHolder(val binding: FavouriteRecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favoritesEntity: FavouritesEntity) {
            binding.favouritesEntity = favoritesEntity
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FavouriteRecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val selectedRecipe = favoriteRecipes[position]
        holder.bind(selectedRecipe)

        holder.binding.favouriteRecipesRowLayout.setOnClickListener {
                val action =
                    FavouriteRecipesFragmentDirections.actionFavouriteRecipesFragmentToDetailsActivity(
                        selectedRecipe.result
                    )
                holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return favoriteRecipes.size
    }

    fun setData(newFavoriteRecipes: List<FavouritesEntity>){
        val favoriteRecipesDiffUtil =
            RecipesDiffUtil(favoriteRecipes, newFavoriteRecipes)
        val diffUtilResult = DiffUtil.calculateDiff(favoriteRecipesDiffUtil)
        favoriteRecipes = newFavoriteRecipes
        diffUtilResult.dispatchUpdatesTo(this)
    }
}