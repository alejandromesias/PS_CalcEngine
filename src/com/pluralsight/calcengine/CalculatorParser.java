package com.pluralsight.calcengine;

public class CalculatorParser {
    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    public void process(String statement) {
        String[] parts = statement.split(" ");
        String commandString = parts[0];
        leftValue = Double.parseDouble(parts[1]);
        rightValue = Double.parseDouble(parts[2]);
        setCommandFromString(commandString);

        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Substract:
                calculator = new Subtracter(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
        }
        calculator.calculate();
        result = calculator.getResult();
    }

    private void setCommandFromString(String commandString){
        if(commandString.equalsIgnoreCase(MathCommand.Add.toString())) {
            this.command = MathCommand.Add;
        } else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString())){
            this.command = MathCommand.Multiply;
        } else if (commandString.equalsIgnoreCase(MathCommand.Substract.toString())){
            this.command = MathCommand.Substract;
        } else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString())) {
            this.command = MathCommand.Divide;
        }
    }

    @Override
    public String toString() {
        String symbol = null;
        switch (command) {
            case Add:
                symbol = "+";
                break;
            case Substract:
                symbol = "-";
                break;
            case Multiply:
                symbol = "*";
                break;
            case Divide:
                symbol = "/";
                break;
        }
        StringBuilder builder = new StringBuilder(20);
        builder.append(leftValue);
        builder.append(symbol);
        builder.append(rightValue);
        builder.append(" = ");
        builder.append(result);
        return builder.toString();
    }
}
