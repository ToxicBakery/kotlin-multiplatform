package com.toxicbakery.multiplatform

import org.w3c.dom.Element
import org.w3c.dom.HTMLButtonElement
import kotlin.browser.document
import kotlin.browser.window

/**
 * Treat an Element as the input/output field of the calculator.
 */
var Element.calculatorInput: String
    get() = textContent ?: ""
    set(value) {
        textContent = value
    }

fun main(vararg args: String) {
    window.onload = {

        /**
         * Register an HTML Button to send the calculator a given action when clicked.
         */
        fun Calculator.registerButton(id: String, action: String) =
                (document.getElementById(id) as HTMLButtonElement)
                        .addEventListener("click", { processAction(action) })


        val inputField = document.getElementById("result")!!
        val calculator = Calculator(
                readResult = { inputField.calculatorInput },
                writeResult = { result -> inputField.calculatorInput = result })

        calculator.registerButton("pow", Calculator.ACTION_POWER)
        calculator.registerButton("clear", Calculator.ACTION_CLEAR)
        calculator.registerButton("zero", Calculator.ACTION_ZERO)
        calculator.registerButton("one", Calculator.ACTION_ONE)
        calculator.registerButton("two", Calculator.ACTION_TWO)
        calculator.registerButton("three", Calculator.ACTION_THREE)
        calculator.registerButton("four", Calculator.ACTION_FOUR)
        calculator.registerButton("five", Calculator.ACTION_FIVE)
        calculator.registerButton("six", Calculator.ACTION_SIX)
        calculator.registerButton("seven", Calculator.ACTION_SEVEN)
        calculator.registerButton("eight", Calculator.ACTION_EIGHT)
        calculator.registerButton("nine", Calculator.ACTION_NINE)
        calculator.registerButton("addition", Calculator.ACTION_ADDITION)
        calculator.registerButton("subtraction", Calculator.ACTION_SUBTRACT)
        calculator.registerButton("multiply", Calculator.ACTION_MULTIPLY)
        calculator.registerButton("divide", Calculator.ACTION_DIVIDE)
        calculator.registerButton("decimal", Calculator.ACTION_DECIMAL)
        calculator.registerButton("enter", Calculator.ACTION_ENTER)
    }
}
