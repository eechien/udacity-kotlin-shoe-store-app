package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


// TODO Not show back button when on this view
class LoginFragment : Fragment() {

    companion object {
        const val LOGIN_SUCCESSFUL: String = "LOGIN_SUCCESSFUL"
    }

    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var binding: FragmentLoginBinding
    private lateinit var savedStateHandle: SavedStateHandle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
        savedStateHandle.set(LOGIN_SUCCESSFUL, false)

        binding.loginButton.setOnClickListener{ view: View ->
            login()
        }
        binding.createAccountButton.setOnClickListener{ view: View ->
            login()
        }
        userViewModel.signInComplete.observe(viewLifecycleOwner, Observer { complete ->
            if (complete == null) {
              // do nothing
            } else if (complete) {
                savedStateHandle.set(LOGIN_SUCCESSFUL, true)
                findNavController().popBackStack()
                userViewModel.completeSignIn()
            } else {
                showErrorMessage()
            }
        })
        return binding.root
    }

    private fun login() {
        val email = binding.emailInput.text.toString()
        val password = binding.passwordInput.text.toString()
        userViewModel.signIn(email, password)
    }

    private fun showErrorMessage() {
        Toast.makeText(this.context, "Must submit an email and password!", Toast.LENGTH_SHORT)
    }
}