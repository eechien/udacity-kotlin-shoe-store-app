package com.udacity.shoestore

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val shoesList = mutableListOf<Shoe>()

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    private val _eventShoeAdded = MutableLiveData<Boolean>()
    val eventShoeAdded: LiveData<Boolean>
        get() = _eventShoeAdded

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    init {
        _eventShoeAdded.value = false
        _errorMessage.value = ""
    }

    fun addShoe(shoe: Shoe?) {
        shoe?.let {
            if (it.name == "") {
                _errorMessage.value = "Name needs a value"
            } else if (it.brand == "") {
                _errorMessage.value = "Brand needs a value"
            } else if (it.size == 0.0) {
                _errorMessage.value = "Size needs to be greater than 0"
            } else if (it.description == "") {
                _errorMessage.value = "Description needs a value"
            } else {
                shoesList.add(it)
                _shoes.value = shoesList
                _eventShoeAdded.value = true
                _errorMessage.value = ""
            }
        }
    }

    fun addShoeComplete() {
        _eventShoeAdded.value = false
    }
}