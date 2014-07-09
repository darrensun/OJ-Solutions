package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Timus 1493 - One Step from Happiness
 * Created by Darren on 14-7-9.
 */
public class Q1493 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int number = Integer.parseInt(in.readLine());
            if (isLucky(number+1) || isLucky(number-1)) // Either previous or next ticket is lucky
                System.out.println("Yes");
            else
                System.out.println("No");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check whether a given ticket is lucky, i.e., the sum of its first three digits equals the
     * sum of its last three digits.
     * @param ticket The given ticket.
     * @return true if the given ticket is lucky, false otherwise.
     */
    public static boolean isLucky(int ticket) {
        int difference = 0;
        // Calculate the sum of the last three digits
        for (int i = 0; i < 3 && ticket != 0; i++) {
            difference += ticket % 10;
            ticket /= 10;
        }
        // Deduct from the sum the first three digits
        for (int i = 0; i < 3 && ticket != 0; i++) {
            difference -= ticket % 10;
            ticket /= 10;
        }
        // The sum of the first three digts equals that of the last three digits if and only if
        // difference == 0.
        if (difference == 0)
            return true;
        return false;
    }
}
