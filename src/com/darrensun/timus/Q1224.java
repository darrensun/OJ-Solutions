package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1224 - Spiral
 * Created by Darren on 14-7-10.
 */
public class Q1224 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        long numOfTurns = 0;    // Avoid overflow when m and n are large
        if (n > m) {
            numOfTurns = ((long) m) / 2 * 4;
            if ((m & 1) == 0)
                numOfTurns--;   // The last round has only three turns
            else
                numOfTurns++;   // One more turn for the last round
        } else {
            numOfTurns = ((long) n) / 2 * 4;
            if ((n & 1) == 0)
                numOfTurns -= 2;    // The last round has only two turns
        }
        System.out.println(numOfTurns);
    }
}
