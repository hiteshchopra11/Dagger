package com.example.daggerandroid.di.component

import com.example.daggerandroid.MainActivity
import com.example.daggerandroid.car.Car
import com.example.daggerandroid.di.module.PetrolEngineModule
import dagger.Component

// @Component makes Dagger create a graph of dependencies
// "modules=" contains all modules which are required by the particular Component
@Component(modules = [PetrolEngineModule::class])
interface CarComponent {

    // The return type  of functions inside the component interface is
    // what can be provided from the container
    fun getCar(): Car

    // Field Injection using inject function as we need to inject the MainActivity
    // inside CarComponent to use the fields(variables) of MainActivity
    fun inject(mainActivity: MainActivity)
}

/** Note-: When we include both DieselEngineModule and PetrolEngineModule, and both have same method i.e
 * start() inside method, we will receive error "Engine is bound multiple times" because Dagger will get
 * confused that which module to use,that is why we should provide just one module to CarComponent
 */