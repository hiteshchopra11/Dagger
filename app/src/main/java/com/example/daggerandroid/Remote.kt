package com.example.daggerandroid

import android.util.Log
import com.example.daggerandroid.car.Car
import javax.inject.Inject

/**Example of Method Dependency Injection
 * We use @Inject constructor() here because we want to use
 * inject Remote class instance to Car class
 */

class Remote @Inject constructor() {
    lateinit var car: Car

    fun provideCar(car: Car) {
        Log.d("Provide Car", "Providing car to remote")
        this.car = car
    }
}