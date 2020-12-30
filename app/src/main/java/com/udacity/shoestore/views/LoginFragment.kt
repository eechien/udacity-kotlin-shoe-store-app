package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        
        val navController = findNavController()

        binding.loginButton.setOnClickListener{ view: View ->
            navController.navigate(R.id.welcomeFragment)
        }
        binding.createAccountButton.setOnClickListener{ view: View ->
            navController.navigate(R.id.welcomeFragment)
        }
        return binding.root
    }
}