package com.example.daggerandroid

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(wheels: Wheels, engine: Engine) {
    fun start() {
        Log.e("Driving", "Driving the Car")
    }
}