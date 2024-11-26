package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput {
    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int

    /**
     * Покажи уровень топлива
     */
    fun getFuelContents(): Int
}