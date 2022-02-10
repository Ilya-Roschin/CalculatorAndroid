package com.university.calculator.app;

public class CalculatorModel {

    StringBuilder inputString = new StringBuilder();
    private static final CalculatorService CALCULATOR_SERVICE = new CalculatorService();

    public void onActionPressed(int actionId) {
        if (inputString.length() < 20) {
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
                case R.id.clean:
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
            }
        } else if (actionId == R.id.clean) {
            inputString.setLength(inputString.length() - 1);
        } else if (actionId == R.id.equals) {
          findResult();
        }
    }

    public String getText() {
        return inputString.toString();
    }

    public void findResult() {
        if (inputString.length() > 0) {
            if(!CALCULATOR_SERVICE.isNumber(inputString)) {
                double result = CALCULATOR_SERVICE.findAnswerFromRPN(CALCULATOR_SERVICE.expressionToRPN(inputString.toString()));
                inputString.delete(0, inputString.length())
                        .append(result);
            }
        }
    }
}
