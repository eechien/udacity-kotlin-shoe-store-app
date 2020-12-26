package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )
        val navController = findNavController()

        if (userViewModel.user.value == null) {
            navController.navigate(R.id.loginFragment)
        }

        binding.instructionsButton.setOnClickListener { view ->
            navController.navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }

        return binding.root
    }
}