package com.udacity.shoestore.views

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

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

        binding.viewShoesButton.setOnClickListener { view ->
            navController.navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }

        return binding.root
    }

}