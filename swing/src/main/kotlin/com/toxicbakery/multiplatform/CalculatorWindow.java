package com.toxicbakery.multiplatform;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

import javax.swing.*;

import static com.toxicbakery.multiplatform.Calculator.*;

public class CalculatorWindow {

    JPanel calculatorView;
    private JTextField textFieldInput;
    private JButton buttonNumberZero;
    private JButton buttonNumberOne;
    private JButton buttonNumberTwo;
    private JButton buttonNumberThree;
    private JButton buttonNumberFour;
    private JButton buttonNumberFive;
    private JButton buttonNumberSix;
    private JButton buttonNumberSeven;
    private JButton buttonNumberEight;
    private JButton buttonNumberNine;
    private JButton buttonNumberDecimal;
    private JButton buttonActionEnter;
    private JButton buttonActionAdd;
    private JButton buttonActionSubtract;
    private JButton buttonActionMultiply;
    private JButton buttonActionDivide;
    private JButton buttonActionClear;
    private JButton buttonActionPower;

    private Calculator calculator = new Calculator(
            (Function0) () -> textFieldInput.getText(),
            (Function1) value -> {
                textFieldInput.setText((String) value);
                return this;
            }
    );

    public CalculatorWindow() {
        buttonNumberZero.addActionListener(e -> calculator.processAction(ACTION_ZERO));
        buttonNumberOne.addActionListener(e -> calculator.processAction(ACTION_ONE));
        buttonNumberTwo.addActionListener(e -> calculator.processAction(ACTION_TWO));
        buttonNumberThree.addActionListener(e -> calculator.processAction(ACTION_THREE));
        buttonNumberFour.addActionListener(e -> calculator.processAction(ACTION_FOUR));
        buttonNumberFive.addActionListener(e -> calculator.processAction(ACTION_FIVE));
        buttonNumberSix.addActionListener(e -> calculator.processAction(ACTION_SIX));
        buttonNumberSeven.addActionListener(e -> calculator.processAction(ACTION_SEVEN));
        buttonNumberEight.addActionListener(e -> calculator.processAction(ACTION_EIGHT));
        buttonNumberNine.addActionListener(e -> calculator.processAction(ACTION_NINE));
        buttonNumberDecimal.addActionListener(e -> calculator.processAction(ACTION_DECIMAL));
        buttonActionEnter.addActionListener(e -> calculator.processAction(ACTION_ENTER));
        buttonActionAdd.addActionListener(e -> calculator.processAction(ACTION_ADDITION));
        buttonActionSubtract.addActionListener(e -> calculator.processAction(ACTION_SUBTRACT));
        buttonActionMultiply.addActionListener(e -> calculator.processAction(ACTION_MULTIPLY));
        buttonActionDivide.addActionListener(e -> calculator.processAction(ACTION_DIVIDE));
        buttonActionClear.addActionListener(e -> calculator.processAction(ACTION_CLEAR));
        buttonActionPower.addActionListener(e -> calculator.processAction(ACTION_POWER));
    }

}
