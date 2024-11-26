package ru.otus.cars

import kotlin.random.Random

fun main() {
    println("\n===> drive cars...")
    driveCars()
    println("\n===> inner test...")
    innerNestedCheck()
    println("\n===> garage make...")
    garageMake()
    println("\n===> model special...")
    println("\n===> get equipment...")
    getEquipment()
    println("\n===> get color...")
    getColor()
    println("\n===> tech checks...")
    techChecks()
    println("\n===> Taz...")
    println(Taz.color)
    println("\n===> refuel...")
    reFuel(Taz,5)
    reFuelCars()
}

fun driveCars() {
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20 и случайную скорость
}

fun innerNestedCheck() {
    val vaz = Vaz2107.build(Car.Plates("123", 77))
    val output = vaz.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    Vaz2107.test(vaz) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
    println("Уровень топлива: ${output.getFuelContents()}") //Ввыводит уровень топлива
}

fun garageMake() {
    val maker = "Дядя Вася"
    val garage = object : CarFactory {
        override fun buildCar(builder: CarBuilder, plates: Car.Plates): Car {
            println("Запил Жигулей у: $maker...")
            println("Машину не проверяем... и в продакшн...")
            return builder.build(plates)
        }
    }

    val vaz = garage.buildCar(Vaz2107, Car.Plates("500", 50))
    println(vaz.toString())
}

fun getEquipment() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Оборудование: ${car.getEquipment()}")
    }
}

fun getColor() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Цвет: ${car.color}")
    }
}

fun techChecks() {
    val vaz1 = Vaz2107.build(Car.Plates("123", 77))
    val vaz2 = Vaz2108.build(Car.Plates("321", 78))

    repairEngine(vaz1)
    repairEngine(vaz2)
}

fun repairEngine(car: VazPlatform) {
    // Проверяем тип двигателя
    // В зависимости от типа двигателя выполняем разные действия
    // when обеспечивает обход всех вариантов перечисления
    when (car.engine) {
        is VazEngine.LADA_2107 -> println("Чистка карбюратора у двигателя объемом ${car.engine.volume} куб.см у машины $car")
        is VazEngine.SAMARA_2108 -> println("Угол зажигания у двигателя объемом ${car.engine.volume} куб.см у машины $car")
    }
}
/**
 * Заправка топливом
 */
fun reFuel(car: Car, liters:Int){
    println()
    println(car.MODEL)
    try {
    println("Уровень топлива до заправки= ${car.carOutput.getFuelContents()}")
   when (car.typeOfFuel) {
            "Petrol" -> fuelPetrol(car, liters)
            "Lpg" -> fuelLpg(car, liters)
        "Petrol&Lpg"-> when(Random.nextInt(0, 1)) {
        0 -> fuelPetrol(car, liters)
        else -> fuelLpg(car, liters)
    }
    }
    println("Заправляем топливо: ${car.typeOfFuel}")
    println("Уровень топлива после заправки= ${car.carOutput.getFuelContents()}")
    }
    catch (e: Error) {
        println("Бак взорвался")
    }
}
fun fuelPetrol(car: Car,liters: Int){CarBuilder.Tank.receiveFuel(car, liters)}
fun fuelLpg(car: Car,liters: Int){CarBuilder.Tank.receiveFuel(car, liters)}
fun reFuelCars(){
        val cars = listOf(
            Vaz2107.build(Car.Plates("123", 77)),
            Vaz2108.build(Car.Plates("321", 78)),
            )
        cars.forEach { car ->
            reFuel(car, 20)
            println("Автомобиль: ${car.MODEL} состояние:${car.toString()}")
        }
}

