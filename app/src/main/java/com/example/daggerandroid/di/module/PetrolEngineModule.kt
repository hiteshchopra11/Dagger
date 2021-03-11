package com.example.daggerandroid.di.module

import com.example.daggerandroid.car.Engine
import com.example.daggerandroid.car.engine.PetrolEngine
import dagger.Module
import dagger.Provides

/* If we directly try to inject Engine interface inside our
 * Car class, we will get an exception as Dagger is not able
 * create an Engine object. We need to use module for the same.
 * We will tell Dagger to use this "module" (provided below with
 * @Module annotation) to create engine object.
 */

@Module
class PetrolEngineModule {

    //Provides is used for every method we want to provide to Car class
    @Provides
    fun providesPetrolEngine(petrolEngine: PetrolEngine): Engine {
        return petrolEngine
    }
}