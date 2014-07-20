package com.darrensun.spoj.arith2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 4452 - Simple Arithmetics II
 * Created by Darren on 14-7-18.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            evaluateExpression();
        }
        out.flush();
    }

    /**
     * Evaluate an arithmetic expression from the stardard input.
     * @throws Exception If the input format is incorrect.
     */
    void evaluateExpression() throws Exception {
        long value = readOperand();
        char operator;
        while ((operator = readOperator()) != '=') {
            long operand = readOperand();
            switch (operator) {
                case '+' : value += operand; break;
                case '-' : value -= operand; break;
                case '*' : value *= operand; break;
                case '/' : value /= operand; break;
            }
        }
        out.println(value);
    }

    /**
     * Read operand (an integer) from the standard input.
     * @return The operand parsed from the standard input.
     * @throws Exception If the input format is incorrect.
     */
    long readOperand() throws Exception {
        StringBuilder operand = new StringBuilder();
        char c = (char) in.read();
        while (c < '0' || c > '9')
            c = (char) in.read();
        do {
            operand.append(c);
            in.mark(1);
            c = (char) in.read();
        } while (c >= '0' && c <= '9');
        return Long.parseLong(operand.toString());
    }

    /**
     * Read an operator from the standard input.
     * @return The operator parsed from the standard input.
     * @throws Exception If the input format is incorrect.
     */
    char readOperator() throws Exception {
        in.reset();
        char c = (char) in.read();
        while (c != '+' && c != '-' && c != '*' && c != '/' && c != '=')
            c = (char) in.read();
        return c;
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

}
