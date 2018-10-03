package com.toxicbakery.multiplatform;

import com.toxicbakery.multiplatform.model.NumericValue;
import com.toxicbakery.multiplatform.operation.*;

import javax.swing.*;

public class CalculatorWindow {

    private static final String ACTION_ENTER = "enter";
    private static final String ACTION_CLEAR = "clear";
    private static final String ACTION_ADDITION = "+";
    private static final String ACTION_SUBTRACT = "-";
    private static final String ACTION_MULTIPLY = "*";
    private static final String ACTION_DIVIDE = "/";
    private static final String ACTION_POWER = "^";
    private static final String ACTION_DECIMAL = ".";
    private static final String[] OPERATIONS = new String[]{
            ACTION_ADDITION,
            ACTION_SUBTRACT,
            ACTION_MULTIPLY,
            ACTION_DIVIDE,
            ACTION_POWER
    };

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

    private Calculator calculator = new Calculator();

    public CalculatorWindow() {
        buttonNumberZero.addActionListener(e -> uiAction("0"));
        buttonNumberOne.addActionListener(e -> uiAction("1"));
        buttonNumberTwo.addActionListener(e -> uiAction("2"));
        buttonNumberThree.addActionListener(e -> uiAction("3"));
        buttonNumberFour.addActionListener(e -> uiAction("4"));
        buttonNumberFive.addActionListener(e -> uiAction("5"));
        buttonNumberSix.addActionListener(e -> uiAction("6"));
        buttonNumberSeven.addActionListener(e -> uiAction("7"));
        buttonNumberEight.addActionListener(e -> uiAction("8"));
        buttonNumberNine.addActionListener(e -> uiAction("9"));
        buttonNumberDecimal.addActionListener(e -> uiAction(ACTION_DECIMAL));
        buttonActionEnter.addActionListener(e -> uiAction(ACTION_ENTER));
        buttonActionAdd.addActionListener(e -> uiAction(ACTION_ADDITION));
        buttonActionSubtract.addActionListener(e -> uiAction(ACTION_SUBTRACT));
        buttonActionMultiply.addActionListener(e -> uiAction(ACTION_MULTIPLY));
        buttonActionDivide.addActionListener(e -> uiAction(ACTION_DIVIDE));
        buttonActionClear.addActionListener(e -> uiAction(ACTION_CLEAR));
        buttonActionPower.addActionListener(e -> uiAction(ACTION_POWER));
    }

    private void uiAction(String action) {
        switch (action) {
            case ACTION_CLEAR:
                textFieldInput.setText("");
                break;
            case ACTION_ENTER:
                calculate();
                break;
            case ACTION_DECIMAL:
                handleDecimalInput();
                break;
            default:
                handleActionInput(action);
                break;
        }
    }

    private void handleDecimalInput() {
        int operationIndex = indexOfOperation();
        int decimalIndex = indexOfDecimal();
        if (decimalIndex <= operationIndex) appendToInput(ACTION_DECIMAL);
    }

    private void handleActionInput(String action) {
        if (actionIsOperation(action)) handleOperationInput(action);
        else {
            if ("0".equals(textFieldInput.getText())) uiAction(ACTION_CLEAR);
            appendToInput(action);
        }
    }

    private void handleOperationInput(String operation) {
        if (isLastInputIsOperation()) replaceLastInputWith(operation);
        else {
            if (inputContainsOperation()) calculate();
            appendToInput(operation);
        }
    }

    private void replaceLastInputWith(String value) {
        String inputText = textFieldInput.getText();
        textFieldInput.setText(inputText.substring(0, inputText.length() - 1) + value);
    }

    private void appendToInput(String value) {
        textFieldInput.setText(textFieldInput.getText() + value);
    }

    private void calculate() {
        String inputText = textFieldInput.getText();
        int operationIndex = indexOfOperation();
        String left = inputText.substring(0, operationIndex);
        String right = inputText.substring(operationIndex + 1);
        String operation = inputText.substring(operationIndex, operationIndex + 1);

        NumericValue resultValue = calculator.calculate(
                new NumericValue(Double.valueOf(left)),
                new NumericValue(Double.valueOf(right)),
                convertOperation(operation));

        textFieldInput.setText(String.valueOf(resultValue.getInput()));
        cleanInput();
    }

    private void cleanInput() {
        String inputText = textFieldInput.getText();
        if (inputText.endsWith(".0")) textFieldInput.setText(inputText.substring(0, inputText.length() - 2));
    }

    private NumericOperation convertOperation(String operation) {
        switch (operation) {
            case ACTION_ADDITION:
                return new AdditionOperation();
            case ACTION_SUBTRACT:
                return new SubtractionOperation();
            case ACTION_MULTIPLY:
                return new MultiplicationOperation();
            case ACTION_DIVIDE:
                return new DivisionOperation();
            case ACTION_POWER:
                return new PowerOperation();
            default:
                throw new RuntimeException("Unhandled operation " + operation);
        }
    }

    private boolean isLastInputIsOperation() {
        String inputText = textFieldInput.getText();
        if (inputText.length() == 0) return false;
        String lastCharacter = String.valueOf(inputText.charAt(inputText.length() - 1));
        for (String operation : OPERATIONS)
            if (lastCharacter.equals(operation)) return true;
        return false;
    }

    private boolean inputContainsOperation() {
        String inputText = textFieldInput.getText();
        for (String operation : OPERATIONS)
            if (inputText.contains(operation)) return true;
        return false;
    }

    private boolean actionIsOperation(String action) {
        for (String operation : OPERATIONS)
            if (operation.equals(action)) return true;
        return false;
    }

    private int indexOfOperation() {
        String inputText = textFieldInput.getText();
        for (String operation : OPERATIONS) {
            int index = inputText.indexOf(operation);
            if (index > -1) return index;
        }
        return -1;
    }

    private int indexOfDecimal() {
        String inputText = textFieldInput.getText();
        return inputText.lastIndexOf(ACTION_DECIMAL);
    }

}
