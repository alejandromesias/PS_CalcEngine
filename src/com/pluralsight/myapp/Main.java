package com.pluralsight.myapp;

import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.CalculatorParser;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathProcessing;

public class Main {

    public static void main(String[] args) {
//        String[] statements = {
//                "divid 100.0 50.0",
//                "add 25.0 92.0",
//                "subtract 225.0 17.0",
//                "add 11.0 3.0",
//                "add 3.0",
//                "add blah 2.0",
//                "power blah blah",
//                "power 2.4 1.2"
//        };
        String[] statements = {
            "add 25.0 92.0"
        };

        MathProcessing[] availableProcessors = new MathProcessing[] {new Adder()};
        for (String statement:statements) {
            DynamicHelper helper = new DynamicHelper(availableProcessors);
            String output = helper.process(statement);
            System.out.println(output);
//            try {
//                CalculatorParser parser = new CalculatorParser();
//                parser.process(statement);
//                System.out.println(parser.toString());
//            } catch (InvalidStatementException exception) {
//                System.out.println(exception.getMessage());
//            }
        }
    }
}
