package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1457 - Heating Main
 * Created by Darren on 14-7-10.
 * The arithmetic mean of the efforts f(x):
 * f(x) = k * [(x-p_1)^2 + ... + (x-p_n)^2] / n
 * By taking the first-order derivative of f(x) and set it to zero, we get a solution
 * x = (p_1 + ... + p_n) / n, which happens to be the arithmetic mean of p_i.
 * It is easy to verify that this is the point where the minimum of f(x) is achieved.
 */
public class Q1457 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            double sum = 0.0;
            for (int i = 0; i < n; i++)
                sum += Integer.parseInt(tokenizer.nextToken());
            System.out.printf("%.6f\n", sum/n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
