package com.darrensun.spoj.sumtrian;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 453 - Sums in a Triangle (tutorial)
 * Created by Darren on 14-7-17.
 * Solved by dynamic programming.
 * For each entry except the ones at two sides, at each line except the first line,
 * there are two entries that can arrive it from the direct upper line. For the entries at the
 * sides, they must go all along the left/right side.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int testcases = Integer.parseInt(tokenizer.nextToken());
        while (testcases-- > 0) {
            tokenizer = new StringTokenizer(in.readLine());
            int lines = Integer.parseInt(tokenizer.nextToken());
            int[] values = new int[lines];
            tokenizer = new StringTokenizer(in.readLine());
            values[0] = Integer.parseInt(tokenizer.nextToken());

            // Main body of DP
            for (int i = 2; i <= lines; i++) {
                tokenizer = new StringTokenizer(in.readLine());
                int temp1 = values[0];
                values[0] = temp1 + Integer.parseInt(tokenizer.nextToken());    // Left side
                for (int j = 1; j < i-1; j++) {
                    int value = Integer.parseInt(tokenizer.nextToken());
                    int temp2 = values[j];
                    values[j] = value + (temp1>temp2 ? temp1 : temp2);
                    temp1 = temp2;
                }
                values[i-1] = temp1 + Integer.parseInt(tokenizer.nextToken());  // Right side
            }

            // Find the maximum value
            int maxValue = 0;
            for (int i = 0; i < lines; i++)
                maxValue = (values[i] > maxValue) ? values[i] : maxValue;

            out.println(maxValue);
        }
        out.flush();
    }
}
