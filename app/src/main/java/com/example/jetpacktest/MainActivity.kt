package com.example.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel:MainViewModel
    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MyObserver())



        sp=getPreferences(Context.MODE_PRIVATE)
        val countReserved=sp.getInt("count_reserved",0)
        viewModel= ViewModelProvider(this, MainViewModelFactory(countReserved)).get(MainViewModel::class.java)

    val clerBtn=findViewById<Button>(R.id.clearBtn)
        clerBtn.setOnClickListener {
            viewModel.clear()
           // refreshCounter()
        }
        refreshCounter()
        val pusOneBtn=findViewById<Button>(R.id.plusOneBtn)

        pusOneBtn.setOnClickListener {
            viewModel.plusOne()

        }

        viewModel.counter.observe(this, Observer{
            count->
            val infoText=findViewById<TextView>(R.id.infoText)
            infoText.text=count.toString()
        })
    }


    override fun onPause() {
        super.onPause()
        sp.edit{
            putInt("count_reserved",viewModel.counter.value?:0)
        }


    }

    private fun refreshCounter(){
        val infoText=findViewById<TextView>(R.id.infoText)
        infoText.text=viewModel.counter.toString()
    }
}