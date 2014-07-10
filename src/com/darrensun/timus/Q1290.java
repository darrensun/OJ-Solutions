package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Timus 1290 - Sabotage
 * Created by Darren on 14-7-10.
 * The numbers after the first stage drops at the indices of input numbers
 * For example, input: 4 1 6
 * 0    1*  2   3   4*  5   6*
 * 3    2   2   2   1   1   0
 * After the second stage, the first number is the largest number a_m in the input,
 * the second number is the difference between a_m and the number t_1 of 1's in the output of the
 * first stage. Note that t1 is also the distance between the largest number and the second
 * largest number (veried by considering the two complete cases when they are the same or
 * different). Hence the second number would be the second largest number in the input. As the
 * reasoning goes, the numbers after the second stage would be those in the input but sorted in
 * non-ascending order.
 */
public class Q1290 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            // Read input numbers
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++)
                numbers[i] = Integer.parseInt(in.readLine());

            Arrays.sort(numbers);   // Sort the numbers

            // Print the sorted numbers in non-ascending order
            PrintWriter out = new PrintWriter(System.out);
            for (int i = n-1; i >= 0; i--)
                out.println(numbers[i]);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
