package com.example.daggerandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerandroid.car.Car
import com.example.daggerandroid.di.component.CarComponent
import com.example.daggerandroid.di.component.DaggerCarComponent
import com.example.daggerandroid.di.module.PetrolEngineModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //Field Injection using @Inject annotation
    @Inject
    lateinit var car1: Car

    //Late initialise CarComponent
    lateinit var carComponent: CarComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an instance of the CarComponent using DaggerCarComponent(generated by Dagger)

        /* If there is any module that has a constructor with values,then there won't be any
         * create() method, in this case, we will have a builder method. */

        //carComponent = DaggerCarComponent.create()

        /* Inside the builder method we call our Module class and create instance of the same with
         * required values. Basically this is how we pass runtime values to the Class
         */

        carComponent =
            DaggerCarComponent.builder().petrolEngineModule(PetrolEngineModule(550)).build()
        // Inject MainActivity in CarComponent, all variables of MainActivity are injected inside CarComponent
        carComponent.inject(this)

        //Call the function driveCar()
        car1.driveCar()
    }
}


/** Note-: If we use Field Injection in Activity directly we will get a NullPointerException because
 *  MainActivity instance is created by Android and not by Dagger, we need to tell Dagger to create all
 *  variables which are marked as inject inside MainActivity to instantiate those objects.
 */
