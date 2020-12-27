package com.udacity.shoestore.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.udacity.shoestore.BR


class Shoe : BaseObservable() {

    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var size: Double = 0.0
        set(value) {
            field = value
            notifyPropertyChanged(BR.size)
        }

    @get:Bindable
    var brand: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.brand)
        }

    @get:Bindable
    var description: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }
}