package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1607 - Taxi
 * Created by Darren on 14-7-10.
 */
public class Q1607 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        boolean agreeOnPetr = true; // In case a >= c at the beginning
        while (a < c) {
            if (a + b < c)
                a += b;
            else {
                agreeOnPetr = false;
                break;
            }
            if (c - d > a)
                c -= d;
            else {
                agreeOnPetr = true;
                break;
            }
        }
        System.out.println(agreeOnPetr ? a : c);
    }
}
