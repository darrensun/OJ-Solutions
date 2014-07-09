package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1263 - Elections
 * Created by Darren on 14-7-9.
 */
public class Q1263 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int[] votes = new int[n];
            int m = Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i < m; i++) {
                votes[Integer.parseInt(in.readLine())-1]++;
            }
            for (int i = 0; i < n; i++)
                System.out.println(String.format("%.2f%%", votes[i] * 100.0 / m));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
