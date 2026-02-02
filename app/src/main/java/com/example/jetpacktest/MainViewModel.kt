package com.example.jetpacktest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel(countReserved:Int): ViewModel() {
    //var counter= MutableLiveData<Int>()

   // init {
   //     counter.value=countReserved
   // }
   val counter: LiveData<Int>
   get()=_scounter
private val _scounter= MutableLiveData<Int>()
 init {
     _scounter.value=countReserved
 }



    fun plusOne(){
        val count=_scounter.value?:0
        _scounter.value=count+1
    }
    fun clear(){
        _scounter.value=0
    }


}