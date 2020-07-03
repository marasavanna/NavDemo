package com.example.navdemo.fragmentA

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentAViewModel : ViewModel() {

    private val _selectedNumber = MutableLiveData<String>()
    val selectedNumber: LiveData<String>
        get() = _selectedNumber


    fun changeText(newText: String) {
        _selectedNumber.value = newText
    }

    override fun onCleared() {
        super.onCleared()
    }
}