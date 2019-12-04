package com.eureka.puzzle01

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SolverKtTest {

    @ParameterizedTest
    @CsvSource("12,2", "14,2", "1969,654", "100756,33583")
    fun `fuel for module`(input: Long, expected: Long) {
        assertThat(fuelFor(Module(input)), equalTo(Fuel(expected)))
    }

    @ParameterizedTest
    @CsvSource("2, 0", "654, 312")
    fun `fuel for fuel`(input: Long, expected: Long) {
        assertThat(extraFuelFor(Fuel(input)), equalTo(Fuel(expected)))
    }

    @ParameterizedTest
    @CsvSource("14, 2", "1969, 966", "100756, 50346")
    fun `total fuel for module`(input: Long, expected: Long) {
        assertThat(totalFuelFor(Module(input)), equalTo(Fuel(expected)))
    }

}