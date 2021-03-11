package com.example.daggerandroid.car.engine

import android.util.Log
import com.example.daggerandroid.car.Engine
import javax.inject.Inject

// @Inject lets Dagger know how to create instance of PetrolEngine

/**Dagger can create an instance of the PetrolEngine only if the class
 * has an empty constructor and @Inject annotation. Integer "powerCapacity" does not
 * have an @Inject annotation, so error is thrown while building
 * if we use the below given lines of code without making any
 * changes in the PetrolEngineModule class */

class PetrolEngine @Inject constructor(private val powerCapacity: Int) : Engine {

    override fun start() {
        Log.d("Petrol engine", "Petrol Engine Started PowerCapacity is $powerCapacity")
    }
}


/** Therefore to use the PetrolEngine class with a Field, we need to manually create instance
 * of PetrolEngine class with relevant fields inside the providesPetrolEngine() method in the
 * PetrolEngineModule instead of passing the instance of PetrolEngine through constructor.
 */