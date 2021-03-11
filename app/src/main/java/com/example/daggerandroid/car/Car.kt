package com.example.daggerandroid.car

import android.util.Log
import javax.inject.Inject


// @Inject lets Dagger know how to create instances of these objects

/*If we directly try to inject Engine interface inside our
 *Car class, we will get an exception as Dagger is not able
 *create an Engine object. We need to use module for the same.
 */
class Car @Inject constructor(private val wheels: Wheels, private val engine: Engine) {
    fun driveCar() {
        engine.start()
        Log.d("Car", "Driving the Car....")
    }
}