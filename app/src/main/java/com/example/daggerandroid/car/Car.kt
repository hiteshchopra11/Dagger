package com.example.daggerandroid.car

import android.util.Log
import com.example.daggerandroid.Remote
import javax.inject.Inject


// @Inject lets Dagger know how to create instances of these objects
// Removed Constructor Injection for Wheels class and used Field Injection for the same below
class Car @Inject constructor(private val engine: Engine) {

    /** Field Injection to provide Wheels Class object to Car
     *  class using Field, instead of passing the same through constructor
     */

    @Inject
    lateinit var wheels: Wheels

    @Inject
    fun provideCarToRemote(remote: Remote) {
        Log.d("Provide car", "Provided car to remote successfully!")
        remote.provideCar(this)
    }

    fun driveCar() {
        Log.d("Wheels", "Wheels using Field Injection")
        engine.start()
        Log.d("Car", "Driving the Car....")
    }
}