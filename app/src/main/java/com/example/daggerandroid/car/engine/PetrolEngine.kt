package com.example.daggerandroid.car.engine

import android.util.Log
import com.example.daggerandroid.car.Engine
import javax.inject.Inject

// @Inject lets Dagger know how to create instance of PetrolEngine
class PetrolEngine @Inject constructor() : Engine {
    override fun start() {
        Log.d("Petrol engine", "Petrol Engine Started")
    }
}