package com.darrensun.spoj.fashion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SPOJ 1025 - Fashion Shows
 * Created by Darren on 14-7-15.
 * The stategy is to pair the hottest man with the hottest woman, the second hottest man and the
 * second hottest woman, and so on.
 * The optimality of this strategy can be proved by mathematical induction.
 * Hotness levels of men: a_n >= ... >= a_1
 * Hotness levels of women: b_n >= ... >= b_1
 * We need to prove that the strategy by pairing a_n with b_n and using the optimal strategy for
 * the remaining n-1 pairs is no worse than that by pairing a_n with b_i and using the optimal
 * strategy for the remaining n-1 pairs.
 * a_n*b_n+...+a_1*b_1 - a_n*b_i+a_{n-1}*b_n+...+a_i*b_{i+1}+a_{i-1}*b_[i-1}+...+a_1*b_1
 * = (a_n-a_{n-1})*b_n + ... + (a_{i+1}-a_i)*b_{i+1} + (a_i-a_n)*b_i
 * >= (a_n-a_{n-1})*b_i + ... + (a_{i+1}-a_i)*b_i + (a_i-a_n) * b_i
 * >= (a_n-a_{n-1}+a_{n-1}-a_{n-2}+...+a_{i+1}-a_{i}+a_i-a_n) * b_i
 * = 0
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());
        for (int t = 0; t < testcases; t++) {
            int n = Integer.parseInt(in.readLine());

            // Read hotness levels of men and women
            int[] men = new int[n];
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
                men[i] = Integer.parseInt(tokenizer.nextToken());
            Arrays.sort(men);
            int[] women = new int[n];
            tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
                women[i] = Integer.parseInt(tokenizer.nextToken());
            Arrays.sort(women);

            // Calculate the maximum sum of the hotness bonds
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += men[i] * women[i];
            out.println(sum);
        }
        out.flush();
    }
}
