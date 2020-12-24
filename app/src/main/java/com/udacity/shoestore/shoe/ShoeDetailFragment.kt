package com.udacity.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoelist.ShoeListViewModel

class ShoeDetailFragment: Fragment() {
    // init with shoe details or empty shoe to create a new one
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_shoe_detail,
                container,
                false
        )
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = viewModel
        binding.lifecycleOwner = this // TODO what is this for?

        val navController = findNavController()

        binding.cancelButton.setOnClickListener { view ->
            navController.navigateUp()
        }
        binding.saveShoeButton.setOnClickListener { view ->
            val shoe = Shoe(
                binding.shoeNameInput.toString(),
                binding.shoeSizeInput.text.toString().toDouble(), // REALLY??
                binding.shoeBrandInput.toString(),
                binding.shoeDescriptionInput.toString()
            )
            viewModel.addShoe(shoe)
            navController.navigateUp()
        }

        return binding.root
    }

}