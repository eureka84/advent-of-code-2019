package com.eureka.puzzle01

import com.eureka.puzzle01.Mass.Companion.ZERO

fun fuelFor(module: Module): Fuel = Fuel(module.mass / 3 - 2)

fun createExtraFuelForGiven(fuelFor: (Mass) -> Mass): (Fuel) -> Fuel =
    { input: Fuel ->
        fun loop(acc: Fuel, fuel: Fuel): Fuel =
            fuelFor(fuel).let { extraFuel ->
                if (extraFuel isLessThan ZERO)
                    acc
                else
                    loop(extraFuel + acc, extraFuel)
            }

        loop(Fuel(0), input)
    }

val extraFuelFor: (Fuel) -> Fuel = createExtraFuelForGiven(::fuelFor)

fun createTotalFuelFor(fuelFor: (Mass) -> Mass, extraFuelFor: (Mass) -> Mass): (Module) -> Fuel =
    { module: Module ->
        fuelFor(module).let { fuel ->
            fuel + extraFuelFor(fuel)
        }
    }

val totalFuelFor: (module: Module) -> Fuel = createTotalFuelFor(::fuelFor, extraFuelFor)

fun main() {
    val result = object {}
        .javaClass
        .getResource("/puzzle01/input.txt")
        .readText()
        .split("\n")
        .map { Mass(it.toLong()) }
        .map { totalFuelFor(it) }
        .sumByDouble { it.mass.toDouble() }

    println(result)
}