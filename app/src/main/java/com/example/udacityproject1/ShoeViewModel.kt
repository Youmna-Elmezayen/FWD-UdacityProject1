package com.example.udacityproject1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.udacityproject1.model.Shoe

class ShoeViewModel : ViewModel()
{
    private var _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList:  MutableLiveData<List<Shoe>> get() = _shoesList

    init {
        _shoesList.value = listOf()
    }

    fun updateShoeList(shoeName: String, shoeSize: Double, shoeCompany: String, shoeDesc: String)
    {
        _shoesList.value = _shoesList.value?.plus(Shoe(shoeName, shoeSize, shoeCompany, shoeDesc))
    }
}