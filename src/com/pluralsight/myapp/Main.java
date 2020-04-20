package com.pluralsight.myapp;

import com.pluralsight.calcengine.CalculatorParser;
import com.pluralsight.calcengine.InvalidStatementException;

public class Main {

    public static void main(String[] args) {
        String[] statements = {
                "divid 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "add 11.0 3.0",
                "add 3.0",
                "add blah 2.0",
                "power blah blah",
                "power 2.4 1.2"
        };

        for (String statement:statements) {
            try {
                CalculatorParser parser = new CalculatorParser();
                parser.process(statement);
                System.out.println(parser.toString());
            } catch (InvalidStatementException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
