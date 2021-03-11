package com.example.daggerandroid.di

import com.example.daggerandroid.Car
import dagger.Component

// @Component makes Dagger create a graph of dependencies
@Component
interface CarComponent {
    // The return type  of functions inside the component interface is
    // what can be provided from the container
    fun getCar():Car
}