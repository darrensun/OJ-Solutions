package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Timus 1567 - SMS-spam
 * Created by Darren on 14-7-9.
 */
public class Q1567 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            char[] slogan = in.readLine().toCharArray();
            int sumOfCost = 0;
            for (int i = 0; i < slogan.length; i++)
                sumOfCost += costOfSingleCharacter(slogan[i]);
            System.out.println(sumOfCost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculate the cost of a given single character.
     * @param c The given single character.
     * @return The cost of the given character.
     */
    public static int costOfSingleCharacter(char c) {
        switch (c) {
            case '.':
            case ' ': return 1;
            case ',': return 2;
            case '!': return 3;
            default: return (c-'a') % 3 + 1;
        }
    }
}
