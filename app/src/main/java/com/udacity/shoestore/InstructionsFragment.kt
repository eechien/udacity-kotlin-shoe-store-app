package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.shoelist.ShoeListViewModel

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_instructions, container, false
        )
        val navController = findNavController()

        binding.addShoeButton.setOnClickListener { view ->
            navController.navigate(R.id.action_instructionsFragment_to_shoeDetailFragment)
        }

        binding.viewShoesButton.setOnClickListener { view ->
            navController.navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }

        return binding.root
    }

}