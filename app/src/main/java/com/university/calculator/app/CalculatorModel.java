package com.university.calculator.app;

import android.widget.Toast;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;

public class CalculatorModel {

    private StringBuilder inputString = new StringBuilder();

    public void onActionPressed(int actionId) {

        if (inputString.length() < 30) {
            switch (actionId) {
                case R.id.zero:
                    inputString.append("0");
                    break;
                case R.id.one:
                    inputString.append("1");
                    break;
                case R.id.two:
                    inputString.append("2");
                    break;
                case R.id.three:
                    inputString.append("3");
                    break;
                case R.id.four:
                    inputString.append("4");
                    break;
                case R.id.five:
                    inputString.append("5");
                    break;
                case R.id.six:
                    inputString.append("6");
                    break;
                case R.id.seven:
                    inputString.append("7");
                    break;
                case R.id.eight:
                    inputString.append("8");
                    break;
                case R.id.nine:
                    inputString.append("9");
                    break;
                case R.id.back:
                    if (inputString.length() > 0) {
                        inputString.setLength(inputString.length() - 1);
                    }
                    break;
                case R.id.point:
                    inputString.append(".");
                    break;
                case R.id.plus:
                    inputString.append("+");
                    break;
                case R.id.minus:
                    if(inputString.length() != 0) {
                        inputString.append("-");
                    }
                    break;
                case R.id.division:
                    inputString.append("/");
                    break;
                case R.id.divisionWithRemainder:
                    inputString.append("%");
                    break;
                case R.id.multiply:
                    inputString.append("*");
                    break;
                case R.id.equals:
                  findResult();
                    break;
                case R.id.ac:
                    inputString.delete(0,inputString.length());
                    break;
                case R.id.sin:
                    inputString.append("SIN(");
                    break;
                case R.id.cos:
                    inputString.append("COS(");
                    break;
                case R.id.tg:
                    inputString.append("TAN(");
                    break;
                case R.id.fact:
                    inputString.append("FACT(");
                    break;
                case R.id.power:
                    inputString.append("^");
                    break;
                case R.id.pi:
                    inputString.append("PI");
                    break;
                case R.id.right_bracket:
                    inputString.append(")");
                    break;
                case R.id.left_bracket:
                    inputString.append("(");
                    break;
                case R.id.exp:
                    inputString.append("e");
                    break;
            }
        } else if (actionId == R.id.back) {
            inputString.setLength(inputString.length() - 1);
        } else if (actionId == R.id.equals) {
          findResult();
        }
    }

    public String getText() {
        return inputString.toString();
    }

    public void findResult() {
        try {
            if (inputString.length() > 0) {
                Expression expression = new Expression(inputString.toString());
                BigDecimal result = expression.eval();
                inputString.delete(0, inputString.length())
                        .append(result);
            }

        } catch (Exception e) {

        }
    }

    public void setInputString(StringBuilder inputString) {
        this.inputString = inputString;
    }
}
