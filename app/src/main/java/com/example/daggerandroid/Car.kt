package com.example.daggerandroid

import android.util.Log
import javax.inject.Inject


// @Inject lets Dagger know how to create instances of these objects
class Car @Inject constructor(wheels: Wheels, engine: Engine) {
    fun driveCar() {
        Log.d("Car", "Driving the Car....")
    }
}