package com.toxicbakery.mppcalculator

import android.app.Activity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.toxicbakery.multiplatform.Calculator

class MainActivity : AppCompatActivity() {

    private val textViewInput: TextView by bind(R.id.textview_input)
    private val buttonPower: Button by bind(R.id.button_power)
    private val buttonClear: Button by bind(R.id.button_clear)
    private val buttonOne: Button by bind(R.id.button_one)
    private val buttonTwo: Button by bind(R.id.button_two)
    private val buttonThree: Button by bind(R.id.button_three)
    private val buttonAddition: Button by bind(R.id.button_addition)
    private val buttonFour: Button by bind(R.id.button_four)
    private val buttonFive: Button by bind(R.id.button_five)
    private val buttonSix: Button by bind(R.id.button_six)
    private val buttonSubtraction: Button by bind(R.id.button_subtraction)
    private val buttonSeven: Button by bind(R.id.button_seven)
    private val buttonEight: Button by bind(R.id.button_eight)
    private val buttonNine: Button by bind(R.id.button_nine)
    private val buttonMultiply: Button by bind(R.id.button_multiply)
    private val buttonDecimal: Button by bind(R.id.button_decimal)
    private val buttonZero: Button by bind(R.id.button_zero)
    private val buttonEnter: Button by bind(R.id.button_enter)
    private val buttonDivide: Button by bind(R.id.button_divide)

    private val calculator: Calculator by lazy {
        Calculator(
                readResult = { textViewInput.text.toString() },
                writeResult = { result -> textViewInput.text = result })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonPower.calculatorAction(Calculator.ACTION_POWER)
        buttonClear.calculatorAction(Calculator.ACTION_CLEAR)
        buttonOne.calculatorAction(Calculator.ACTION_ONE)
        buttonTwo.calculatorAction(Calculator.ACTION_TWO)
        buttonThree.calculatorAction(Calculator.ACTION_THREE)
        buttonAddition.calculatorAction(Calculator.ACTION_ADDITION)
        buttonFour.calculatorAction(Calculator.ACTION_FOUR)
        buttonFive.calculatorAction(Calculator.ACTION_FIVE)
        buttonSix.calculatorAction(Calculator.ACTION_SIX)
        buttonSubtraction.calculatorAction(Calculator.ACTION_SUBTRACT)
        buttonSeven.calculatorAction(Calculator.ACTION_SEVEN)
        buttonEight.calculatorAction(Calculator.ACTION_EIGHT)
        buttonNine.calculatorAction(Calculator.ACTION_NINE)
        buttonMultiply.calculatorAction(Calculator.ACTION_MULTIPLY)
        buttonDecimal.calculatorAction(Calculator.ACTION_DECIMAL)
        buttonZero.calculatorAction(Calculator.ACTION_ZERO)
        buttonEnter.calculatorAction(Calculator.ACTION_ENTER)
        buttonDivide.calculatorAction(Calculator.ACTION_DIVIDE)

        if (savedInstanceState == null) calculator.processAction(Calculator.ACTION_CLEAR)
        else calculator.processAction(savedInstanceState.calculatorInput)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.calculatorInput = textViewInput.text.toString()
    }

    private var Bundle.calculatorInput: String
        get() = getString(EXTRA_INPUT, Calculator.ACTION_CLEAR)
        set(value) {
            putString(EXTRA_INPUT, value)
        }

    private fun View.calculatorAction(action: String) =
            setOnClickListener { calculator.processAction(action) }

    private fun <T : View> Activity.bind(@IdRes id: Int): Lazy<T> = lazy { findViewById<T>(id) }

    companion object {
        private const val EXTRA_INPUT = "EXTRA_INPUT"
    }

}
