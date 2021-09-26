package com.udacity.shoestore
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ListViewModel:ViewModel() {

    private  var _shoeList =  MutableLiveData<MutableList<Shoe>>()
    val shoeList :LiveData<MutableList<Shoe>>
    get() = _shoeList

    init {
        Log.i("view model","initialise")
        _shoeList.value = ArrayList()

        addList("ShoeA",6.5,"CompanyA","Soft")
    }
    fun addList(name: String, size: Double, company: String, description: String)
    {
        Log.i("Add","view")
         _shoeList.value?.add(Shoe(name,size,company,description))
        Timber.i(_shoeList.value?.joinToString())

    }


/*
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

*/


}