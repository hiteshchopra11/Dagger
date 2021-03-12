package com.example.daggerandroid.car.engine

import android.util.Log
import com.example.daggerandroid.car.Engine
import javax.inject.Inject
import javax.inject.Named

// @Inject lets Dagger know how to create instance of PetrolEngine

/**Dagger can create an instance of the PetrolEngine only if the class
 * has an empty constructor and @Inject annotation. Integer "powerCapacity" does not
 * have an @Inject annotation, so error is thrown while building
 * if we use the below given lines of code without making any
 * changes in the PetrolEngineModule class */

class PetrolEngine @Inject constructor(
    @Named("power") private val powerCapacity: Int,
    @Named("engine") private val engineCapacity: Int
) : Engine {

    override fun start() {
        Log.d(
            "Petrol engine",
            "Petrol Engine Started PowerCapacity is $powerCapacity and Engine capacity is $engineCapacity"
        )
    }
}

/** If we don't use Named constructor in this case, the compiler will get confused and error will be thrown that
 *  Integer bound multiple times. To this, we differentiate between the two using @Named annotation
 */

/** Therefore to use the PetrolEngine class with a Field, we need to manually create instance
 * of PetrolEngine class with relevant fields inside the providesPetrolEngine() method in the
 * PetrolEngineModule instead of passing the instance of PetrolEngine through constructor.
 */