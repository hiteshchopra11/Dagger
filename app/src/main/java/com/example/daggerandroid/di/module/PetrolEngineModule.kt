package com.example.daggerandroid.di.module

import com.example.daggerandroid.car.Engine
import com.example.daggerandroid.car.engine.PetrolEngine
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class PetrolEngineModule @Inject constructor() {

    /*We return the instance of PetrolEngine passed through the
     *constructor only if petrolEngine has no parameters to be passed*/

    /*  @Provides
     *  fun providesPetrolEngine(petrolEngine: PetrolEngine): Engine{
     *      return petrolEngine
     *  }
     */

    /*As our PetrolEngine class has parameters now, we can't directly pass
    * the instance of PetrolEngine through the constructor, instead we need
    * to manually create the instance with the appropriate parameters. The
    * below code achieves this but uses "hard-coded" value.*/

    /* @Provides
     *  fun providesPetrolEngine(): Engine {
     *     return PetrolEngine(100)
     *  }
     */

    /* To pass the value "dynamically" we can use powerCapacity value from the
     * PetrolEngineModule constructor. Instructions on how to pass the values
     */

    /* @Provides
     *  fun providesPetrolEngine(): Engine {
     *     return PetrolEngine(powerCapacity)
     *  }
     */

    /* We can also use Component.Builder inside our CarComponent to directly pass
     * the values into the providesPetrolEngine() method instead of the PetrolEngineModule
     * class. We use @Component.Builder for Builder interface and @BindsInstance to inject
     * values into the @Provides method
     */

    @Provides
    fun providesPetrolEngine(powerCapacity: Int): Engine {
        return PetrolEngine(powerCapacity)
    }

}