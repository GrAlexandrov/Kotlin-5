package ru.otus.cars

import kotlin.random.Random

/**
 * Сборщик машины
 */
sealed interface CarBuilder {
    /**
     * Собери машину
     */
    fun build(plates: Car.Plates): Car

    object Tank{
    fun getContents(car: Car): Int{
        return car.fuelLevel
    }
    fun receiveFuel(car: Car, liters: Int){
        car.fuelLevel+=liters
    }
}
}
sealed class TankMouth(val typeOfFuel:String){
    class LADA_2107 : TankMouth("Lpg")
    class SAMARA_2108 : TankMouth("Petrol")
    class Taz : TankMouth(when(Random.nextInt(0, 2)){
        0->"Petrol"
        else -> {"Lpg"}
    })
}
