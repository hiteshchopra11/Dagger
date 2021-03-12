package com.example.daggerandroid.di.component

import com.example.daggerandroid.MainActivity
import com.example.daggerandroid.car.Car
import com.example.daggerandroid.di.module.PetrolEngineModule
import com.example.daggerandroid.di.module.WheelsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

// @Component makes Dagger create a graph of dependencies
// "modules=" contains all modules which are required by the particular Component
@Component(modules = [PetrolEngineModule::class, WheelsModule::class])
interface CarComponent {

    // The return type  of functions inside the component interface is
    // what can be provided from the container
    fun getCar(): Car

    // Field Injection using inject function as we need to inject the MainActivity
    // inside CarComponent to use the fields(variables) of MainActivity
    fun inject(mainActivity: MainActivity)


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun powerCapacity(@Named("power") powerCapacity: Int): Builder

        @BindsInstance
        fun engineCapacity(@Named("engine") engineCapacity: Int): Builder

        fun build(): CarComponent
    }
}


/**The @Named annotation is good for identifying which provider to be used when we are trying to inject the dependency of the same type.
 * For example in this case when we have multiple @BindsInstance or @Provides methods or arguments with same data type, we can used @Named
 * annotation so that Dagger can differentiate between them, otherwise "<Data Type> is bound multiple times" error will be thrown.
 */