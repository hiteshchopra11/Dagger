package com.example.daggerandroid

import android.app.Application
import com.example.daggerandroid.di.component.CarComponent
import com.example.daggerandroid.di.component.DaggerCarComponent

class CarApp : Application() {

    lateinit var carComponent: CarComponent

    override fun onCreate() {
        super.onCreate()
        carComponent = DaggerCarComponent
            .builder()
            .powerCapacity(500)
            .engineCapacity(700)
            .build()
    }

    fun carComponent(): CarComponent {
        return carComponent
    }
}

/** Note-: As we have now set our component at application level, it will live throughout the app.
 * So now if we rotate our screen, MainActivity is recreated but as it gets the carComponent from the
 * application, it will remain same throughout the app.
 */