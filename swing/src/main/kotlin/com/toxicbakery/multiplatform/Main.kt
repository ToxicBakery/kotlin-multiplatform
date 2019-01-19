package com.toxicbakery.multiplatform

import com.toxicbakery.logging.Arbor
import com.toxicbakery.logging.Seedling
import javax.swing.JFrame

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Arbor.sow(Seedling())
            JFrame("Calculator").apply {
                contentPane = CalculatorWindow(::Calculator).calculatorView
                defaultCloseOperation = JFrame.EXIT_ON_CLOSE
                pack()
                isVisible = true
            }
        }
    }
}
