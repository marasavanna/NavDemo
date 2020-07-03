package com.example.navdemo.fragmentC

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentCViewModel : ViewModel() {

    private var _dummies = MutableLiveData<List<Dummy>>()
    val dummies: LiveData<List<Dummy>>
        get() = _dummies

    private var _firstVisiblePosition = MutableLiveData(0)
    val firstVisiblePosition: LiveData<Int>
        get() = _firstVisiblePosition


    fun setVisiblePosition(position: Int) {
        _firstVisiblePosition.value = position
    }


    fun setItems() {
        val mockDummies = mutableListOf<Dummy>()
        mockDummies.add(Dummy("Ana", "1"))
        mockDummies.add(Dummy("Michael", "2"))
        mockDummies.add(Dummy("Denis", "3"))
        mockDummies.add(Dummy("Kyle", "4"))
        mockDummies.add(Dummy("Loan", "5"))
        mockDummies.add(Dummy("Geal", "6"))
        mockDummies.add(Dummy("Testsjns", "7"))
        mockDummies.add(Dummy("Nsns", "8"))
        mockDummies.add(Dummy("MyName", "9"))
        mockDummies.add(Dummy("MyTest", "10"))
        mockDummies.add(Dummy("Jail", "11"))
        mockDummies.add(Dummy("Apple", "12"))
        mockDummies.add(Dummy("Paris", "13"))
        mockDummies.add(Dummy("Loco", "14"))
        mockDummies.add(Dummy("Tear", "15"))
        mockDummies.add(Dummy("Nono", "16"))

        _dummies.value = mockDummies
    }
}