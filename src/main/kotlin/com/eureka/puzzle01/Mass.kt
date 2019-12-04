package com.eureka.puzzle01

typealias Fuel = Mass
typealias Module = Mass

data class Mass(val amount: Long) {
    infix fun isLessThan(other: Mass): Boolean = this.amount <= other.amount

    operator fun plus(other: Mass): Mass =
        Mass(this.amount + other.amount)

    companion object {
        val ZERO = Mass(0)
    }
}