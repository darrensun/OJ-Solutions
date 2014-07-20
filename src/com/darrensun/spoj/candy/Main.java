package com.darrensun.spoj.candy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 2123 - Candy I
 * Created by Darren on 14-7-15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n;
        while ((n = Integer.parseInt(in.readLine())) != -1) {
            // Read the number of candies in each packet, and calculate the total number of candies
            int[] packets = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                packets[i] = Integer.parseInt(in.readLine());
                sum += packets[i];
            }

            // Candies cannot be distributed evenly
            if (sum % n != 0) {
                out.println(-1);
                continue;
            }

            // Find the number of moves by counting the number of candies moved into packets
            // whose candies are initially less than the average
            int average = sum / n;
            int moves = 0;
            for (int i = 0; i < n; i++) {
                if (packets[i] < average)
                    moves += average - packets[i];
            }

            out.println(moves);
        }
        out.flush();
    }
}
