package com.pluralsight.myapp;

import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.Subtracter;

public class Main {

    public static void main(String[] args) {

        String[] statements = {
            "divide 100.0 50.0",
            "add 25.0 92.0",
            "subtract 225.0 17.0",
            "multiply 2.4 1.2",
            "addy 25.0 92.0",
            "add 3.0",
            "add blah 2.0",
            "power blah blah",
        };

        MathProcessing[] availableProcessors = new MathProcessing[] {
            new Adder(),
            new Multiplier(),
            new Subtracter(),
            new Divider()
        };

        for (String statement : statements) {
            try {
                DynamicHelper helper = new DynamicHelper(availableProcessors);
                String output = helper.process(statement);
                System.out.println(output);
            } catch (InvalidStatementException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
