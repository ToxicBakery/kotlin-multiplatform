package com.toxicbakery.multiplatform

import javax.swing.JFrame

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            JFrame("Calculator").apply {
                contentPane = CalculatorWindow(::Calculator).calculatorView
                defaultCloseOperation = JFrame.EXIT_ON_CLOSE
                pack()
                isVisible = true
            }
        }
    }
}
