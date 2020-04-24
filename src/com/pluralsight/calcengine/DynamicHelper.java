package com.pluralsight.calcengine;

public class DynamicHelper {
    private double leftValue;
    private double rightValue;
    double result;
    private MathProcessing[] mathProcessors;

    public DynamicHelper(MathProcessing[] mathProcessors) {
        this.mathProcessors = mathProcessors;
    }

    public String process(String statement) throws InvalidStatementException {
        String[] parts = statement.split(MathProcessing.SEPARATOR);
        if(parts.length != 3)
            throw new InvalidStatementException("Incorrect number of fields", statement);
        String commandString = parts[0];

        MathProcessing chosenProcessor = null;

        for (MathProcessing aProcessor: mathProcessors) {
            if (commandString.equalsIgnoreCase(aProcessor.getKeyWord())) {
                chosenProcessor = aProcessor;
                break;
            }
        }

        try {
            leftValue = Double.parseDouble(parts[1]);
            rightValue = Double.parseDouble(parts[2]);
        } catch (NumberFormatException exception) {
            throw new InvalidStatementException("Non-numeric data", statement, exception);
        }

        try {
            result = chosenProcessor.doCalculation(leftValue, rightValue);
        } catch (RuntimeException e) {
            throw new InvalidStatementException("Invalid Command", statement, e);
        }

        StringBuilder builder = new StringBuilder(20);
        builder.append(leftValue);
        builder.append(chosenProcessor.getSymbol());
        builder.append(rightValue);
        builder.append(" = ");
        builder.append(result);

        return builder.toString();
    }
}
