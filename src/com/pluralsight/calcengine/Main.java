package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args) {
        String[] statements = {
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculatorParser parser = new CalculatorParser();
        for (String statement:statements) {
            parser.process(statement);
            System.out.println(parser.toString());
        }

    }
}
