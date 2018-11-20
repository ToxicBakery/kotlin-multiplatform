package com.toxicbakery.multiplatform

import com.toxicbakery.multiplatform.model.NumericValue
import com.toxicbakery.multiplatform.operation.*

class Calculator(
        private val readResult: () -> String,
        private val writeResult: (result: String) -> Unit
) {

    fun processAction(action: String) {
        when (action) {
            ACTION_CLEAR -> writeResult("")
            ACTION_ENTER -> calculate()
            ACTION_DECIMAL -> handleDecimalInput()
            else -> handleActionInput(action)
        }
    }

    private fun handleDecimalInput() {
        val operationIndex = indexOfOperation()
        val decimalIndex = indexOfDecimal()
        if (decimalIndex <= operationIndex) appendToInput(ACTION_DECIMAL)
    }

    private fun handleActionInput(action: String) {
        if (actionIsOperation(action))
            handleOperationInput(action)
        else {
            if ("0" == readResult()) processAction(ACTION_CLEAR)
            appendToInput(action)
        }
    }

    private fun handleOperationInput(operation: String) {
        if (wasLastInputAnOperation())
            replaceLastInputWith(operation)
        else {
            if (inputContainsOperation()) calculate()
            appendToInput(operation)
        }
    }

    private fun replaceLastInputWith(value: String) {
        val inputText = readResult()
        writeResult(inputText.substring(0, inputText.length - 1) + value)
    }

    private fun appendToInput(value: String) {
        writeResult(readResult() + value)
    }

    private fun calculate() {
        val inputText = readResult()
        val operationIndex = indexOfOperation()
        val left = inputText.substring(0, operationIndex)
        val right = inputText.substring(operationIndex + 1)
        val operation = inputText.substring(operationIndex, operationIndex + 1)
        val resultValue = convertOperation(operation)
                .calculate(
                        left = NumericValue(left.toDouble()),
                        right = NumericValue(right.toDouble())
                )

        writeResult(resultValue.input.toString())
        cleanInput()
    }

    private fun cleanInput() {
        val inputText = readResult()
        if (inputText.endsWith(".0")) writeResult(inputText.substring(0, inputText.length - 2))
    }

    private fun convertOperation(operation: String): NumericOperation = when (operation) {
        ACTION_ADDITION -> AdditionOperation()
        ACTION_SUBTRACT -> SubtractionOperation()
        ACTION_MULTIPLY -> MultiplicationOperation()
        ACTION_DIVIDE -> DivisionOperation()
        ACTION_POWER -> PowerOperation()
        else -> throw RuntimeException("Unhandled operation $operation")
    }

    private fun wasLastInputAnOperation(): Boolean {
        val inputText = readResult()
        if (inputText.isEmpty()) return false
        val lastCharacter = inputText[inputText.length - 1].toString()
        return OPERATIONS.firstOrNull { operation -> lastCharacter == operation } != null
    }

    private fun inputContainsOperation(): Boolean {
        val inputText = readResult()
        for (operation in OPERATIONS)
            if (inputText.contains(operation)) return true
        return false
    }

    private fun actionIsOperation(action: String): Boolean {
        for (operation in OPERATIONS)
            if (operation == action) return true
        return false
    }

    private fun indexOfOperation(): Int {
        val inputText = readResult()
        for (operation in OPERATIONS) {
            val index = inputText.indexOf(operation)
            if (index > -1) return index
        }
        return -1
    }

    private fun indexOfDecimal(): Int {
        val inputText = readResult()
        return inputText.lastIndexOf(ACTION_DECIMAL)
    }

    companion object {
        const val ACTION_ZERO = "0"
        const val ACTION_ONE = "1"
        const val ACTION_TWO = "2"
        const val ACTION_THREE = "3"
        const val ACTION_FOUR = "4"
        const val ACTION_FIVE = "5"
        const val ACTION_SIX = "6"
        const val ACTION_SEVEN = "7"
        const val ACTION_EIGHT = "8"
        const val ACTION_NINE = "9"
        const val ACTION_ENTER = "enter"
        const val ACTION_CLEAR = "clear"
        const val ACTION_ADDITION = "+"
        const val ACTION_SUBTRACT = "-"
        const val ACTION_MULTIPLY = "*"
        const val ACTION_DIVIDE = "/"
        const val ACTION_POWER = "^"
        const val ACTION_DECIMAL = "."
        private val OPERATIONS = arrayOf(
                ACTION_ADDITION,
                ACTION_SUBTRACT,
                ACTION_MULTIPLY,
                ACTION_DIVIDE,
                ACTION_POWER
        )
    }

}
