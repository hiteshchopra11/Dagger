package com.example.daggerandroid.di

import com.example.daggerandroid.Car
import com.example.daggerandroid.MainActivity
import dagger.Component

// @Component makes Dagger create a graph of dependencies
@Component
interface CarComponent {

    // The return type  of functions inside the component interface is
    // what can be provided from the container
    fun getCar():Car

    // Field Injection using inject function as we need to inject the MainActivity
    // inside CarComponent to use the fields(variables) of MainActivity
    fun inject(mainActivity: MainActivity)

}