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

    object Tank {
        fun getContents(car: Car): Int {
            return car.fuelLevel
        }

        fun receiveFuel(car: Car, liters: Int) {
            car.fuelLevel += liters
        }
    }


}

enum class TankMouth(val typeOfFuel: String) {
    LADA_2107("Lpg"),
    SAMARA_2108("Petrol"),
    Taz(
        when (Random.nextInt(0, 2)) {
            1 -> "Lpg"
            else -> "Petrol"
        }
    )
}