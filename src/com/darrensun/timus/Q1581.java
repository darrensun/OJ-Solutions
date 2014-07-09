package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Timus 1581 - Teamwork
 * Created by Darren on 14-7-9.
 */
public class Q1581 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int n = Integer.parseInt(in.readLine());
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int previous = Integer.parseInt(tokenizer.nextToken());
            int count = 1;  // Count the number of consecutive same numbers
            for (int i = 1; i < n; i++) {
                int current = Integer.parseInt(tokenizer.nextToken());
                if (current == previous) {  // The same number as the previous one
                    count++;
                } else {    // A different number encountered
                    out.print(String.format("%d %d ", count, previous));
                    previous = current;
                    count = 1;
                }
            }
            out.print(String.format("%d %d", count, previous));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
