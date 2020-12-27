package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_list.*

class ShoeListFragment: Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_shoe_list,
                container,
                false
        )
        navController = findNavController()
        binding.shoeListViewModel = viewModel
        binding.lifecycleOwner = this

        binding.addShoeButton.setOnClickListener { view ->
            navController.navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        viewModel.shoes.observe(viewLifecycleOwner, { newList ->
            addShoes(newList)
        })

        return binding.root
    }

    private fun addShoes(shoes: List<Shoe>) { // tODO change this to a listener
        var linearLayout = binding.shoeListLinearLayoutView
        for (shoe in shoes) {
            val shoeItemLayoutBinding = DataBindingUtil.inflate<ShoeItemBinding>(
                LayoutInflater.from(requireContext()),
                R.layout.shoe_item,
                linearLayout,
                false
            )
            shoeItemLayoutBinding.shoe = shoe
            linearLayout.addView(shoeItemLayoutBinding.root)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}