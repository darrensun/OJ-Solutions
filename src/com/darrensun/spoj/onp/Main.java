package com.darrensun.spoj.onp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * SPOJ 4 - Transform the Expression
 * Created by Darren on 14-7-15.
 * A typical application of stack.
 */
public class Main {
    private static PrintWriter out = new PrintWriter(System.out);

    // Operator priority
    private static Map<Character, Integer> priority = new HashMap<Character, Integer>();
    static {
        priority.put('(', 0);
        priority.put('+', 1);
        priority.put('-', 2);
        priority.put('*', 3);
        priority.put('/', 4);
        priority.put('^', 5);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(in.readLine());
        for (int t = 0; t < testcases; t++) {
            String expression = in.readLine();
            transformIntoRPNForm(expression);
        }
        out.flush();
    }

    /**
     * Transform an algebraic expression with brackets into Reverse Polish Notation form.
     * @param expression An algebraic expression.
     */
    public static void transformIntoRPNForm(String expression) {
        if (expression == null || expression.equals(""))
            return;
        Deque<Character> stack = new ArrayDeque<Character>();

        // Process each character one by one
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c >= 'a' && c <= 'z') { // Always output operands
                out.print(c);
            } else if (c == ')') {  // Expression within the brackets is done
                while (stack.peek() != '(')
                    out.print(stack.pop());
                stack.pop();
            } else if (c == '(' || stack.peek() == null ||
                    priority.get(c) > priority.get(stack.peek())) {
                stack.push(c);
            }  else {   // Priority of c is smaller than that of the top operator
                out.print(stack.pop());
                stack.push(c);
            }
        }

        // Print the remaining operators in the stack
        while (stack.peek() != null)
            out.print(stack.pop());

        out.println();
    }
}
