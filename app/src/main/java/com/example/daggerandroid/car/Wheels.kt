package com.example.daggerandroid.car

import com.example.daggerandroid.car.wheels.Rims
import com.example.daggerandroid.car.wheels.Tyres

/** Assume Wheels is not our class but a third party class which
 *  we don't have access to for modification, so we can't use @Inject
 *  In this case we can't pass wheels in constructor of WheelsModule
 *  class, instead we create Wheels object manually and return them
 */

//Now wheels is dependent on Rims and Tyres classes
class Wheels constructor(private val rims: Rims, private val tyres: Tyres) {
}