package com.example.recipes_app.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import coil.load
import com.example.recipes_app.R
import com.example.recipes_app.bindingadapters.RecipesRowBindings
import com.example.recipes_app.databinding.FragmentOverviewBinding
import com.example.recipes_app.models.Result
import com.example.recipes_app.util.Constants.Companion.RECIPE_RESULT_KEY
import com.example.recipes_app.util.retrieveParcelable

class OverviewFragment : Fragment() {


    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result = args!!.retrieveParcelable<Result>(RECIPE_RESULT_KEY) as Result

        if (myBundle != null) {
            binding.mainImageView.load(myBundle.image)
            binding.titleTextView.text = myBundle.title
            binding.likesTextView.text = myBundle.aggregateLikes.toString()
            binding.timeTextView.text = myBundle.readyInMinutes.toString()
            RecipesRowBindings.parseHtml(binding.summaryTextView, myBundle.summary)

            updateColors(myBundle.vegetarian, binding.vegetarianTextView, binding.vegetarianImageView)
            updateColors(myBundle.vegan, binding.veganTextView, binding.veganImageView)
            updateColors(myBundle.cheap, binding.cheapTextView, binding.cheapImageView)
            updateColors(myBundle.dairyFree, binding.dairyFreeTextView, binding.dairyFreeImageView)
            updateColors(myBundle.glutenFree, binding.glutenFreeTextView, binding.glutenFreeImageView)
            updateColors(myBundle.veryHealthy, binding.healthyTextView, binding.healthyImageView)
        }

        return binding.root
    }

    private fun updateColors(stateIsOn: Boolean, textView: TextView, imageView: ImageView) {
        if (stateIsOn) {
            imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}