package com.toxicbakery.multiplatform

import com.toxicbakery.multiplatform.model.NumericValue
import com.toxicbakery.multiplatform.operation.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun addition() {
        val left = NumericValue(1.0)
        val right = NumericValue(2.0)
        val calculator = Calculator()
        val result = calculator.calculate(left, right, AdditionOperation())
        assertEquals(NumericValue(3.0), result)
    }

    @Test
    fun subtraction() {
        val left = NumericValue(1.0)
        val right = NumericValue(2.0)
        val calculator = Calculator()
        val result = calculator.calculate(left, right, SubtractionOperation())
        assertEquals(NumericValue(-1.0), result)
    }

    @Test
    fun division() {
        val left = NumericValue(1.0)
        val right = NumericValue(2.0)
        val calculator = Calculator()
        val result = calculator.calculate(left, right, DivisionOperation())
        assertEquals(NumericValue(0.5), result)
    }

    @Test
    fun multiplication() {
        val left = NumericValue(1.0)
        val right = NumericValue(2.0)
        val calculator = Calculator()
        val result = calculator.calculate(left, right, MultiplicationOperation())
        assertEquals(NumericValue(2.0), result)
    }

    @Test
    fun power() {
        val left = NumericValue(2.0)
        val right = NumericValue(2.0)
        val calculator = Calculator()
        val result = calculator.calculate(left, right, PowerOperation())
        assertEquals(NumericValue(4.0), result)
    }

}
