package com.example.daggerandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerandroid.di.DaggerCarComponent

class MainActivity : AppCompatActivity() {
    lateinit var car: Car
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        car = DaggerCarComponent.create().getCar()
        car.start()
    }
}