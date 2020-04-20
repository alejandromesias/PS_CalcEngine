package com.pluralsight.calcengine;

public class CalculatorParser {
    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    public void process(String statement) throws InvalidStatementException{
        //flushFields();
        String[] parts = statement.split(" ");
        if(parts.length != 3)
            throw new InvalidStatementException("Incorrect number of fields", statement);
        String commandString = parts[0];

        try {
            leftValue = Double.parseDouble(parts[1]);
            rightValue = Double.parseDouble(parts[2]);
        } catch (NumberFormatException exception){
            throw new InvalidStatementException("Non-numeric data", statement, exception);
        }
        setCommandFromString(commandString);
        if (command == null)
            throw new InvalidStatementException("Invalid Command", statement);

        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
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
        } else if (commandString.equalsIgnoreCase(MathCommand.Subtract.toString())){
            this.command = MathCommand.Subtract;
        } else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString())) {
            this.command = MathCommand.Divide;
        }
    }

    private void flushFields() {
        command = null;
        leftValue = 0;
        rightValue = 0;
        result = 0;
    }

    @Override
    public String toString() {
        String symbol = null;
        switch (command) {
            case Add:
                symbol = "+";
                break;
            case Subtract:
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
