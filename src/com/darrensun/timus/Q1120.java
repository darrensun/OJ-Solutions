package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1120 - Sum of Sequential Numbers
 * Created by Darren on 14-7-11.
 * (2a+p-1)p / 2 = n
 */
public class Q1120 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (double p = (int)Math.sqrt(2*n); p >= 1; p--) {
            double a = ((2*n)/p-p+1) / 2;
            if (a == (int)a) {
                System.out.printf("%d %d", (int)a, (int)p);
                break;
            }
        }
    }
}
