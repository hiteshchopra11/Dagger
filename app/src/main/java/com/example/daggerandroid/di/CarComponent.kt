package com.example.daggerandroid.di

import com.example.daggerandroid.Car
import dagger.Component

@Component
interface CarComponent {
    fun getCar():Car
}