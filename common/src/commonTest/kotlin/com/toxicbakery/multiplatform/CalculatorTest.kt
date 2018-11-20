package com.toxicbakery.multiplatform

import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun addition() {
        var output = "1.0+2.0"
        Calculator(
                readResult = { output },
                writeResult = { result -> output = result }
        ).processAction(Calculator.ACTION_ENTER)
        assertEquals("3", output)
    }

    @Test
    fun subtraction() {
        var output = "1.0-2.0"
        Calculator(
                readResult = { output },
                writeResult = { result -> output = result }
        ).processAction(Calculator.ACTION_ENTER)
        assertEquals("-1", output)
    }

    @Test
    fun division() {
        var output = "1.0/2.0"
        Calculator(
                readResult = { output },
                writeResult = { result -> output = result }
        ).processAction(Calculator.ACTION_ENTER)
        assertEquals("0.5", output)
    }

    @Test
    fun multiplication() {
        var output = "1.0*2.0"
        Calculator(
                readResult = { output },
                writeResult = { result -> output = result }
        ).processAction(Calculator.ACTION_ENTER)
        assertEquals("2", output)
    }

    @Test
    fun power() {
        var output = "1.0^2.0"
        Calculator(
                readResult = { output },
                writeResult = { result -> output = result }
        ).processAction(Calculator.ACTION_ENTER)
        assertEquals("1", output)
    }

    @Test
    fun clear() {
        var output = ""
        Calculator(
                readResult = { output },
                writeResult = { result -> output = result }
        ).processAction(Calculator.ACTION_CLEAR)
        assertEquals("0", output)
    }

    @Test
    fun decimal() {
        var output = "1"
        Calculator(
                readResult = { output },
                writeResult = { result -> output = result }
        ).processAction(Calculator.ACTION_DECIMAL)
        assertEquals("1.", output)
    }

}
