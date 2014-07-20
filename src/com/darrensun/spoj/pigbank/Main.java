package com.darrensun.spoj.pigbank;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SPOJ 39 - Piggy-Bank
 * Created by Darren on 14-7-20.
 * Solved by DP.
 * dp(i,w): minimum value by using coins of type 1...i given total weight w
 * v_i, w_i: value and weight for coins of type i
 * dp(i,w) = min{dp(i-1,w), dp(i,w-w_i)+v_i}
 * One-dimensional array suffices to store necessary information.
 */
public class Main {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static String MIN_AMOUNT = "The minimum amount of money in the piggy-bank is %d.\n";
    public static String IMPOSSIBLE = "This is impossible.";
    public static int MAX_VALUE = 2000000000;

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
    }

    void solve() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int totalWeight = -Integer.parseInt(tokenizer.nextToken()) +
                Integer.parseInt(tokenizer.nextToken());

        // Initialized a table(array) for DP
        int[] minValues = new int[totalWeight+1];
        Arrays.fill(minValues, MAX_VALUE);
        minValues[0] = 0;

        // Main body for DP
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(in.readLine());
            int value = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            for (int j = weight; j <= totalWeight; j++) {
                // Using one more of the current coin leads to smaller value
                if (minValues[j-weight]+value < minValues[j])
                    minValues[j] = minValues[j-weight]+value;
            }
        }

        if (minValues[totalWeight] < MAX_VALUE)
            out.printf(MIN_AMOUNT, minValues[totalWeight]);
        else
            out.println(IMPOSSIBLE);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
