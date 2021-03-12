package com.example.daggerandroid.car

import android.util.Log
import com.example.daggerandroid.Remote
import javax.inject.Inject


// @Inject lets Dagger know how to create instances of these objects
// Removed Constructor Injection for Wheels class and used Field Injection for the same below
class Car @Inject constructor(private val engine: Engine, private val driver: Driver) {

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
        /*If we don't use Singleton class in Driver, everytime a
          new instance of driver will be created when driveCar()
          is called from different instances of the same CarComponent.
          But if we use a @Singleton annotation in Driver class and
          CarComponent, then a single instance of Driver will
          be used throughout the component(not the application/activity)*/

        Log.e("Driver", "Driver is $driver")
        Log.d("Wheels", "Wheels using Field Injection")
        engine.start()
        Log.d("Car", "Driving the Car....")
    }
}

/** Note-: In this code, Singleton is limited to the component and not the whole application
 * meaning that everytime a new component will be created by the Activity, a new instance of the
 * Driver class will be created. So, this is the drawback of Singleton is that single instance is
 * limited to the Component and every time a new component is created(like on screen rotation), the
 * new instance of the Driver Class will be created.
 *
 * In order to solve this problem, we should have CarComponent in Application Level, check
 * "Component-Application-Level" branch of the repository for the code.
 */