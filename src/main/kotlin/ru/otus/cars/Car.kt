package ru.otus.cars

import kotlin.random.Random

/**
 * Машина целиком
 */
interface Car : CarInput {
    var fuelLevel: Int
    val typeOfFuel:String
    val MODEL:String
    /**
     * Номерной знак
     */
    val plates: Plates

    /**
     * Цвет машины
     */
    val color: String

    /**
     * Следит за машиной
     */
    val carOutput: CarOutput

    /**
     * Получить оборудование
     */
    fun getEquipment(): String

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)
}
