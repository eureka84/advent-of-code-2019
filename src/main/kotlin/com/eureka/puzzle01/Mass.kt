package com.eureka.puzzle01

typealias Fuel = Mass
typealias Module = Mass

data class Mass(val mass: Long) {
    infix fun isLessThan(other: Mass): Boolean = this.mass <= other.mass

    operator fun plus(other: Mass): Mass =
        Mass(this.mass + other.mass)

    companion object {
        val ZERO = Mass(0)
    }
}