package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Timus 1001 - Reverse Root
 * Created by Darren on 14-7-7.
 */
public class Q1001 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Deque<Long> stack = new ArrayDeque<Long>();
        String str;
        while ((str = in.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            while (tokenizer.hasMoreTokens()) {
                stack.push(Long.parseLong(tokenizer.nextToken()));
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        while (stack.peek() != null) {
            out.print(String.format("%.4f\n", Math.sqrt(stack.pop())));
        }
        out.flush();
    }
}
