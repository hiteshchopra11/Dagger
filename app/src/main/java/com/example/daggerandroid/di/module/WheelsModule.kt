package com.example.daggerandroid.di.module

import android.util.Log
import com.example.daggerandroid.car.Wheels
import com.example.daggerandroid.car.wheels.Rims
import com.example.daggerandroid.car.wheels.Tyres
import dagger.Module
import dagger.Provides

@Module
class WheelsModule {

    // Dagger uses @Provides to create Rims and Tyres object and finally
    // these instances are injected to Wheels

    @Provides
    fun providesRims(): Rims {
        Log.d("Rims", "Rims")
        return Rims()
    }

    @Provides
    fun providesTyres(): Tyres {
        Log.d("Tyres", "Tyres")
        return Tyres()
    }


    //Dagger now knows how to create rims and tyres object as we have used @Provides and
    //defined methods to provide the
    @Provides
    fun providesWheels(rims: Rims, tyres: Tyres): Wheels {

        // We manually create Wheels class object and return it
        Log.d("Wheels", "Wheels Module with tyres and rims")
        return Wheels(rims, tyres)
    }
}