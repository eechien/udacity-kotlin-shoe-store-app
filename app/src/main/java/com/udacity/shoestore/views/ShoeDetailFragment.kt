package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ShoeViewModel

class ShoeDetailFragment: Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_shoe_detail,
                container,
                false
        )
        val navController = findNavController()

        with(binding) {
            lifecycleOwner = this@ShoeDetailFragment
            shoe = Shoe()
            shoeViewModel = viewModel
            cancelButton.setOnClickListener {
                navController.navigateUp()
            }
        }

        viewModel.eventShoeAdded.observe(viewLifecycleOwner, { shoeAdded ->
            if (shoeAdded) {
                viewModel.addShoeComplete()
                navController.navigateUp()
            }
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, { error ->
            if (error != "") {
                Toast.makeText(this.context, error, Toast.LENGTH_LONG).show()
            }
        })

        return binding.root
    }

}