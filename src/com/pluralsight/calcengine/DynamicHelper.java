package com.pluralsight.calcengine;

public class DynamicHelper {

    private MathProcessing[] mathProcessors;

    public DynamicHelper(MathProcessing[] mathProcessors) {
        this.mathProcessors = mathProcessors;
    }

    public String process(String statement) {
        String[] parts = statement.split(MathProcessing.SEPARATOR);

        String commandString = parts[0];

        MathProcessing chosenProcessor = null;

        for (MathProcessing aProcessor: mathProcessors) {
            if (commandString.equalsIgnoreCase(aProcessor.getKeyWord())) {
                chosenProcessor = aProcessor;
                break;
            }
        }
        double leftValue = Double.parseDouble(parts[1]);
        double rightValue = Double.parseDouble(parts[2]);
        double result = chosenProcessor.doCalculation(leftValue,rightValue);

        StringBuilder builder = new StringBuilder(20);
        builder.append(leftValue);
        builder.append(chosenProcessor.getKeyWord());
        builder.append(rightValue);
        builder.append(" = ");
        builder.append(result);

        return builder.toString();
    }
}
